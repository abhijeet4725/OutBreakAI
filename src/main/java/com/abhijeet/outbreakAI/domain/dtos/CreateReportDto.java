package com.abhijeet.outbreakAI.domain.dtos;

import com.abhijeet.outbreakAI.domain.entities.Disease;
import com.abhijeet.outbreakAI.domain.entities.Hospital;
import com.abhijeet.outbreakAI.domain.enums.Gender;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateReportDto {
    private Integer patientAge;
    private Gender patientGender;
    private Disease diseaseName;
    private Hospital hospitalName;
    private List<String> symptoms;
    private String diagnosis;
    private Integer dataReported;
}
