package com.enviro.assessment.grad001.LebeleThabangAdmore.contollers;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.DisposalGuideLineRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.DisposalGuideLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/guidelines")
public class DisposalGuideLineController {

    @Autowired
    private DisposalGuideLineService disposalGuideLineService;

    @GetMapping
    public List<DisposalGuideLineDTO> getGuideLines() {
        return disposalGuideLineService.getAllDisposalGuideLines();
    }
    @GetMapping("{id}")
    public DisposalGuideLineDTO getGuideLine(
            @PathVariable Long id) {
        return disposalGuideLineService.getDisposalGuideLineById(id);
    }

    @PostMapping("{categoryId}")
    public void saveGuideLine(
            @RequestBody DisposalGuideLineRequest guideLineRequest,
            @PathVariable("categoryId") Long categoryId) {
        disposalGuideLineService.addDisposalGuideLine(guideLineRequest,categoryId);
    }

    @PutMapping("{id}/guideline/{categoryId}")
    public void updateGuideLine (@PathVariable("id") Long id,
                                @RequestBody DisposalGuideLineRequest guideLineRequest,
                                @PathVariable("categoryId") Long categoryId) {
        disposalGuideLineService.updateDisposalGuideLine(id,guideLineRequest,categoryId);
    }

    @DeleteMapping("{id}")
    public void deleteGuideLine(
            @PathVariable Long id) {
        disposalGuideLineService.deleteDisposalGuideLine(id);
    }
}
