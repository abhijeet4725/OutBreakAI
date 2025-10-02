package com.abhijeet.outbreakAI.service.impl;

import com.abhijeet.outbreakAI.domain.dtos.CreateReportDto;
import com.abhijeet.outbreakAI.domain.dtos.ReportResponseDto;
import com.abhijeet.outbreakAI.domain.entities.*;
import com.abhijeet.outbreakAI.domain.enums.RiskScore;
import com.abhijeet.outbreakAI.repo.*;
import com.abhijeet.outbreakAI.service.PatientReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientReportServiceImpl implements PatientReportService {
    private final PatientReportRepository patientReportRepository;
    private final DiseaseRepository diseaseRepository;
    private final HospitalRepository hospitalRepository;
    private final ModelInsightsRepository modelInsightsRepository;
    private final OutbreakAlertRepository outbreakAlertRepository;

    @Override
    public ReportResponseDto createReport(CreateReportDto createReportDto) {
        Disease disease = diseaseRepository.findByName(createReportDto.getDiseaseName())
                .orElseThrow(() -> new RuntimeException("Disease not found"));
        Hospital hospital = hospitalRepository.findByName(createReportDto.getHospitalName())
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        PatientReport report = PatientReport.builder()
                .patientAge(createReportDto.getPatientAge())
                .patientGender(createReportDto.getPatientGender())
                .disease(disease)
                .hospital(hospital)
                .symptoms(createReportDto.getSymptoms())
                .diagnosis(createReportDto.getDiagnosis())
                .dataReported(createReportDto.getDataReported())
                .build();

        patientReportRepository.save(report);

        ModelInsights insights = ModelInsights.builder()
                .patientReport(report)
                .llmSummary("Mock summary: Patient may have " + disease.getName())
                .riskScore(RiskScore.B) // simple mock, could randomize
                .build();

        modelInsightsRepository.save(insights);

        if (insights.getRiskScore().equals(RiskScore.Z)) {
            OutbreakAlert alert = OutbreakAlert.builder()
                    .disease(disease)
                    .location(hospital.getCity())
                    .alertLevel(com.abhijeet.outbreakAI.domain.enums.AlertLevel.L3)
                    .message("High risk outbreak detected for " + disease.getName())
                    .build();
            outbreakAlertRepository.save(alert);
        }

        return ReportResponseDto.builder()
                .reportId(report.getId())
                .patientAge(report.getPatientAge())
                .patientGender(report.getPatientGender())
                .symptoms(report.getSymptoms())
                .diagnosis(report.getDiagnosis())
                .dataReported(report.getDataReported())
                .llmSummary(insights.getLlmSummary())
                .riskScore(insights.getRiskScore())
                .build();

    }

    @Override
    public ReportResponseDto getReportById(UUID id) {
        PatientReport patientReport = patientReportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report Not Found"));
        ModelInsights modelInsights = modelInsightsRepository.findById(patientReport.getModelInsights().getId()).orElseThrow(() -> new RuntimeException("Insight Not Found"));

        return ReportResponseDto.builder()
                .reportId(id)
                .patientAge(patientReport.getPatientAge())
                .patientGender(patientReport.getPatientGender())
                .symptoms(patientReport.getSymptoms())
                .diagnosis(patientReport.getDiagnosis())
                .dataReported(patientReport.getDataReported())
                .llmSummary(modelInsights.getLlmSummary())
                .riskScore(modelInsights.getRiskScore())
                .build();
    }

    @Override
    public List<ReportResponseDto> getAllReport(UUID id) {

        return patientReportRepository.findAll()
                .stream()
                .map(report -> {
                    ModelInsights insights = report.getModelInsights();
                    if (insights == null) {
                        throw new RuntimeException("Insight not found for report: " + report.getId());
                    }

                    return ReportResponseDto.builder()
                            .reportId(report.getId())
                            .patientAge(report.getPatientAge())
                            .patientGender(report.getPatientGender())
                            .symptoms(report.getSymptoms())
                            .diagnosis(report.getDiagnosis())
                            .dataReported(report.getDataReported())
                            .llmSummary(insights.getLlmSummary())
                            .riskScore(insights.getRiskScore())
                            .build();
                })
                .toList();
    }

}
