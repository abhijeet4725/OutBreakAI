package com.abhijeet.outbreakAI.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "hospital")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "contact_info")
    private String contactInfo;

    // TODO
    // Patient report relation
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientReport> patientReports = new ArrayList<>();


}
