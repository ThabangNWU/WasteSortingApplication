package com.enviro.assessment.grad001.LebeleThabangAdmore.services.impl;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.RequestValidationException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.mapper.DisposalGuideLineDTOMapper;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.Category;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.DisposalGuideLine;
import com.enviro.assessment.grad001.LebeleThabangAdmore.repositories.CategoryRepository;
import com.enviro.assessment.grad001.LebeleThabangAdmore.repositories.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.DisposalGuideLineRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.DisposalGuideLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DisposalGuideLineServiceImpl implements DisposalGuideLineService {
   @Autowired
   private DisposalGuidelineRepository disposalGuidelineRepository;
   @Autowired
   private DisposalGuideLineDTOMapper disposalGuideLineDTOMapper;
   @Autowired
   private CategoryRepository categoryRepository;

    @Override
    public List<DisposalGuideLineDTO> getAllDisposalGuideLines() {
        return disposalGuidelineRepository.findAll()
                .stream()
                .map(disposalGuideLineDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public DisposalGuideLineDTO getDisposalGuideLineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .map(disposalGuideLineDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "disposal guide line with id [%s] not found".formatted(id)
                ));
    }

    @Override
    public void deleteDisposalGuideLine(Long id) {
        checkIfDisposalGuideLineExistsOrThrow(id);
        disposalGuidelineRepository.deleteById(id);
    }

    private void checkIfDisposalGuideLineExistsOrThrow(Long id) {
        if(!disposalGuidelineRepository.existsDisposalGuideLineById(id)) {
            throw new ResourceNotFoundException(
                    "disposal guide line with id [%s] not found".formatted(id)
            );
        }
    }

    @Override
    public void addDisposalGuideLine(DisposalGuideLineRequest guideLineRequest, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(" category with id [%s] not found".formatted(categoryId)
                ));

        DisposalGuideLine disposalGuideLine = new DisposalGuideLine();
        disposalGuideLine.setCategory(category);
        disposalGuideLine.setDescription(guideLineRequest.description());
        disposalGuidelineRepository.save(disposalGuideLine);
    }

    @Override
    public void updateDisposalGuideLine(Long id, DisposalGuideLineRequest guideLineRequest,Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(" category with id [%s] not found".formatted(categoryId)
                ));

        DisposalGuideLine disposalGuideLine = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disposal guideline with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if(guideLineRequest.description() != null && !guideLineRequest.description().equals(disposalGuideLine.getDescription())) {
            disposalGuideLine.setDescription(guideLineRequest.description());
            changes = true;
        }

        if(category.getName() != null) {
            disposalGuideLine.setCategory(category);
            changes = true;
        }

        if(!changes) {
            throw new RequestValidationException("no data changes");
        }

        disposalGuidelineRepository.save(disposalGuideLine);
    }
}
