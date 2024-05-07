package com.enviro.assessment.grad001.LebeleThabangAdmore.dtos;

import com.enviro.assessment.grad001.LebeleThabangAdmore.models.DisposalGuideLine;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.RecyclingTip;

import java.util.List;

public record CategoryDTO(Long id,String name, List<DisposalGuideLine> guidelines, List<RecyclingTip> tips) {
}
