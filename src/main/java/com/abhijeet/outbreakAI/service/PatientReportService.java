package com.abhijeet.outbreakAI.service;


import com.abhijeet.outbreakAI.domain.dtos.CreateReportDto;
import com.abhijeet.outbreakAI.domain.dtos.ReportResponseDto;
import com.abhijeet.outbreakAI.domain.entities.PatientReport;

import java.util.List;
import java.util.UUID;

public interface PatientReportService {
    ReportResponseDto createReport(CreateReportDto createReportDto);
    ReportResponseDto getReportById(UUID id);
    List<ReportResponseDto> getAllReport(UUID id);
}
