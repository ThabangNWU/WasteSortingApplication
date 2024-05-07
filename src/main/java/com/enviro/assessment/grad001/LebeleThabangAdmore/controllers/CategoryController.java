package com.enviro.assessment.grad001.LebeleThabangAdmore.controllers;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.CategoryDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.CategoryRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.categories();
    }

    @GetMapping("/{id}/category")
    public CategoryDTO getCategory(
            @PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{name}")
    public CategoryDTO getCategoryByName(
            @PathVariable("name") String name ) {
       return categoryService.getCategoryByName(name);
    }

    @PostMapping()
    public void addCategory (
            @RequestBody @Validated CategoryRequest categoryRequest) {
        categoryService.addCategory(categoryRequest);
    }
    @PutMapping("/{id}")
    public void updateCategory(
            @PathVariable("id") Long id,
            @RequestBody @Validated CategoryRequest categoryRequest) {
        categoryService.updateCategory(id,categoryRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCategory (@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

}
