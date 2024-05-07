package com.enviro.assessment.grad001.LebeleThabangAdmore.services;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.RecyclingTipDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.RecyclingTip;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.RecyclingTipRequest;

import java.util.List;

public interface RecyclingTipService {

    List<RecyclingTipDTO> recyclingTips();
    RecyclingTipDTO getRecyclingTipById(Long id);
    void addRecyclingTip(RecyclingTipRequest recyclingTipRequest,Long categoryId);
    void updateRecyclingTip(Long id, RecyclingTipRequest recyclingTipRequest, Long categoryId);
    void deleteRecyclingTip(Long id);
}
