package com.enviro.assessment.grad001.LebeleThabangAdmore.repositories;

import com.enviro.assessment.grad001.LebeleThabangAdmore.models.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingTipRepository extends JpaRepository<RecyclingTip,Long> {
boolean existsRecyclingTipById(Long id);
}
