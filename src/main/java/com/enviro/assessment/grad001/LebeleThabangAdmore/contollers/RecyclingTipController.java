package com.enviro.assessment.grad001.LebeleThabangAdmore.contollers;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.RecyclingTipDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.RecyclingTipRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTipDTO> getTips() {
        return recyclingTipService.recyclingTips();
    }
    @GetMapping("{recycleTipId}")
    public RecyclingTipDTO getTip(
            @PathVariable("recycleTipId") Long recycleTipId) {
        return recyclingTipService.getRecyclingTipById(recycleTipId);
    }
    @PostMapping("{categoryId}")
    public void saveTip (
            @RequestBody RecyclingTipRequest recyclingTipRequest ,
            @PathVariable("categoryId") Long categoryId) {
        recyclingTipService.addRecyclingTip(recyclingTipRequest , categoryId);
    }
    @PutMapping("{id}/tip/{categoryId}")
    public void updateTip (@PathVariable("id") Long id,
                           @RequestBody RecyclingTipRequest recyclingTipRequest,
                           @PathVariable("categoryId") Long categoryId) {
        recyclingTipService.updateRecyclingTip(id,recyclingTipRequest,categoryId);
    }
    @DeleteMapping("{recycleTipId}")
    public void deleteTip(
            @PathVariable("recycleTipId") Long recycleTipId ) {
        recyclingTipService.deleteRecyclingTip(recycleTipId);
    }
}
