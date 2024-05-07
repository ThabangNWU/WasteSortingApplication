package com.enviro.assessment.grad001.LebeleThabangAdmore.repositories;

import com.enviro.assessment.grad001.LebeleThabangAdmore.models.DisposalGuideLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideLine,Long> {
 boolean existsDisposalGuideLineById(Long id);
}
