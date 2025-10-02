package com.abhijeet.outbreakAI.repo;

import com.abhijeet.outbreakAI.domain.entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DiseaseRepository extends JpaRepository<Disease, UUID> {
    Optional<Disease> findByName(Disease name);
}
