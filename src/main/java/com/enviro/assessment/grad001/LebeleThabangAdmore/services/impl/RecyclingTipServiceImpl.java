package com.enviro.assessment.grad001.LebeleThabangAdmore.services.impl;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.RecyclingTipDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.mapper.RecyclingTipDTOMapper;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.Category;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.RecyclingTip;
import com.enviro.assessment.grad001.LebeleThabangAdmore.repositories.CategoryRepository;
import com.enviro.assessment.grad001.LebeleThabangAdmore.repositories.RecyclingTipRepository;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.RecyclingTipRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    @Autowired
    RecyclingTipRepository recyclingTipRepository;
    @Autowired
    RecyclingTipDTOMapper recyclingTipDTOMapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<RecyclingTipDTO> recyclingTips() {
        return recyclingTipRepository.findAll().stream()
                .map(recyclingTipDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public RecyclingTipDTO getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .map(recyclingTipDTOMapper)
                .orElseThrow( () -> new ResourceNotFoundException(
                        "Recycling tip with id [%s] not found".formatted(id)
                ));
    }

    @Override
    public void addRecyclingTip(RecyclingTipRequest recyclingTipRequest ,Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(" category with id [%s] not found".formatted(categoryId)
                ));
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setCategory(category);
        recyclingTip.setTip(recyclingTipRequest.tip());

        recyclingTipRepository.save(recyclingTip);
    }

    @Override
    public void updateRecyclingTip(Long id, RecyclingTipRequest recyclingTipRequest, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(" category with id [%s] not found".formatted(categoryId)
                ));

        RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
                .orElseThrow( () ->new ResourceNotFoundException(
                        "Recycling tip with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if(recyclingTipRequest.tip() != null && !recyclingTipRequest.tip().equals(recyclingTip)) {
            changes = true;
            recyclingTip.setTip(recyclingTipRequest.tip());
        }

        if(category != null ) {
            changes = true;
            recyclingTip.setCategory(category);
        }
    }

    @Override
    public void deleteRecyclingTip(Long id) {
        checkIfRecyclingExistsOrThrow(id);
        recyclingTipRepository.deleteById(id);
    }

    private void checkIfRecyclingExistsOrThrow(Long id) {
        if(!recyclingTipRepository.existsRecyclingTipById(id)) {
            throw new ResourceNotFoundException(
                    "Recycling tip with id [%s] not found".formatted(id)
            );
        }
    }
}
