package com.enviro.assessment.grad001.LebeleThabangAdmore.services;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.CategoryDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> categories ();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO getCategoryByName(String name);
    void addCategory(CategoryRequest categoryRequest);
    void deleteCategory(Long id);
    void updateCategory(Long id, CategoryRequest categoryRequest);
}
