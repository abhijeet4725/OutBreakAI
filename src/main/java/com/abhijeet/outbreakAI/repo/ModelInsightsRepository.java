package com.abhijeet.outbreakAI.repo;

import com.abhijeet.outbreakAI.domain.entities.ModelInsights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelInsightsRepository extends JpaRepository<ModelInsights, UUID> {
}
