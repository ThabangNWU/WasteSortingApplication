package com.enviro.assessment.grad001.LebeleThabangAdmore.services;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.DisposalGuideLine;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.DisposalGuideLineRequest;

import java.util.List;

public interface DisposalGuideLineService {

    List<DisposalGuideLineDTO> getAllDisposalGuideLines();
    DisposalGuideLineDTO getDisposalGuideLineById(Long id);
    void deleteDisposalGuideLine(Long id);
    void addDisposalGuideLine(DisposalGuideLineRequest guideLineRequest, Long categoryId);
    void updateDisposalGuideLine(Long id, DisposalGuideLineRequest guideLineRequest,Long categoryId);
}
