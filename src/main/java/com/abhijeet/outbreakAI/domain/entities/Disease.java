package com.abhijeet.outbreakAI.domain.entities;

import com.abhijeet.outbreakAI.domain.enums.SeverityLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "disease")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level")
    private SeverityLevel severityLevel;

    // TODO
    // Patient Report
    @OneToMany(mappedBy = "disease", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PatientReport> patientReports = new ArrayList<>();

    // TODO
    // OutbreakAlert
    @OneToMany(mappedBy = "disease", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<OutbreakAlert> outbreakAlerts = new ArrayList<>();

}
