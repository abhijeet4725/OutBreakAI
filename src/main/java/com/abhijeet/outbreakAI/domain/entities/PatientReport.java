package com.abhijeet.outbreakAI.domain.entities;

import com.abhijeet.outbreakAI.domain.enums.Gender;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient_report")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "patient_age", nullable = false)
    private Integer patientAge;

    @Column(name = "patient_gender", nullable = false)
    private Gender patientGender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_id", nullable = false)
    private Disease disease;

    @OneToOne(mappedBy = "patientReport")
    private ModelInsights modelInsights;


    @Type(JsonType.class)
    @Column(name = "symptoms", columnDefinition = "jsonb")
    private List<String> symptoms;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "data_reported")
    private Integer dataReported;

}
