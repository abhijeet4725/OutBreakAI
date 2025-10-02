package com.abhijeet.outbreakAI.repo;

import com.abhijeet.outbreakAI.domain.entities.OutbreakAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutbreakAlertRepository extends JpaRepository<OutbreakAlert, UUID> {
}
