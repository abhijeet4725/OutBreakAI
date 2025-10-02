package com.abhijeet.outbreakAI.domain.dtos;

import com.abhijeet.outbreakAI.domain.enums.Gender;
import com.abhijeet.outbreakAI.domain.enums.RiskScore;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportResponseDto {
    private UUID reportId;
    private Integer patientAge;
    private Gender patientGender;
    private List<String> symptoms;
    private String diagnosis;
    private Integer dataReported;

    private String llmSummary;
    private RiskScore riskScore;
}

