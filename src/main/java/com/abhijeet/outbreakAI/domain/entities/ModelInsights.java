package com.abhijeet.outbreakAI.domain.entities;

import com.abhijeet.outbreakAI.domain.enums.RiskScore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.Banner;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "model_insights")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelInsights {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "llm_summary", nullable = false)
    private String llmSummary;

    // TODO
    // PatientReport
    @OneToOne
    @JoinColumn(name = "patient_report_id", referencedColumnName = "id", nullable = false)
    private PatientReport patientReport;


    @Enumerated(EnumType.STRING)
    @Column(name = "risk_score", nullable = false)
    private RiskScore riskScore;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
