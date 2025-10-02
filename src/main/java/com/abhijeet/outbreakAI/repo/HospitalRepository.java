package com.abhijeet.outbreakAI.repo;

import com.abhijeet.outbreakAI.domain.entities.Hospital;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {
    Hospital findByName(String name);
    Boolean existsByName(String name);
}
