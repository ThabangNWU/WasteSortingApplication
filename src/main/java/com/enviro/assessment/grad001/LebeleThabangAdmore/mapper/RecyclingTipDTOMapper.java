package com.enviro.assessment.grad001.LebeleThabangAdmore.mapper;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.RecyclingTipDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.RecyclingTip;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class RecyclingTipDTOMapper implements Function<RecyclingTip, RecyclingTipDTO> {
    @Override
    public RecyclingTipDTO apply(RecyclingTip recyclingTip) {
        return new RecyclingTipDTO(
                recyclingTip.getId(),
                recyclingTip.getTip(),
                recyclingTip.getCategory()
        );
    }
}
