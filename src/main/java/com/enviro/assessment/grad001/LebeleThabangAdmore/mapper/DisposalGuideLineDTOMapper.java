package com.enviro.assessment.grad001.LebeleThabangAdmore.mapper;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.DisposalGuideLine;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class DisposalGuideLineDTOMapper implements Function<DisposalGuideLine, DisposalGuideLineDTO> {
    @Override
    public DisposalGuideLineDTO apply(DisposalGuideLine disposalGuideLine) {
        return new DisposalGuideLineDTO(
                disposalGuideLine.getId(),
                disposalGuideLine.getDescription(),
                disposalGuideLine.getCategory()
        );
    }
}
