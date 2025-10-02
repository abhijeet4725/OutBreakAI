package com.abhijeet.outbreakAI.repo;


import com.abhijeet.outbreakAI.domain.entities.PatientReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientReportRepository extends JpaRepository<PatientReport, UUID> {

}
