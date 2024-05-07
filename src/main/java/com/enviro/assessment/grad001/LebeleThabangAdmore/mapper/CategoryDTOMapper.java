package com.enviro.assessment.grad001.LebeleThabangAdmore.mapper;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.CategoryDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CategoryDTOMapper implements Function<Category, CategoryDTO> {
    @Override
    public CategoryDTO apply(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getGuidelines(),
                category.getTips()
        );
    }
}
