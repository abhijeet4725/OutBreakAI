package com.abhijeet.outbreakAI.domain.entities;

import com.abhijeet.outbreakAI.domain.enums.AlertLevel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "outbreak_alert")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class OutbreakAlert {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "location", nullable = false)
    private String location;

    // TODO
    // Disease relation

    @Enumerated(EnumType.STRING)
    @Column(name = "alert_level", nullable = false)
    private AlertLevel alertLevel;

    @Column(name = "message", nullable = false)
    private String message;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_id", nullable = false)
    private Disease disease;
}
