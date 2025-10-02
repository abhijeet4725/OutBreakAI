package com.abhijeet.outbreakAI.repo;

import com.abhijeet.outbreakAI.domain.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {
    Optional<Hospital> findByName(Hospital name);
    Boolean existsByName(String name);
}
