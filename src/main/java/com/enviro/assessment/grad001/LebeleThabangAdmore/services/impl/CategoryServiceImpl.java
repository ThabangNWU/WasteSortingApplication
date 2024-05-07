package com.enviro.assessment.grad001.LebeleThabangAdmore.services.impl;

import com.enviro.assessment.grad001.LebeleThabangAdmore.dtos.CategoryDTO;
import com.enviro.assessment.grad001.LebeleThabangAdmore.requests.CategoryRequest;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.DuplicateResourceException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.RequestValidationException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.LebeleThabangAdmore.mapper.CategoryDTOMapper;
import com.enviro.assessment.grad001.LebeleThabangAdmore.models.Category;
import com.enviro.assessment.grad001.LebeleThabangAdmore.repositories.CategoryRepository;
import com.enviro.assessment.grad001.LebeleThabangAdmore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    @Override
    public List<CategoryDTO> categories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryDTOMapper)
                .orElseThrow( () -> new ResourceNotFoundException(
                        "category with id [%s] not found".formatted(id)
                ));
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name)
                .map(categoryDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "category with name [%s] not found".formatted(name)
                ));
    }

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        // check if category exists
        String name = categoryRequest.name();
        if(categoryRepository.existsCategoryByName(name)) {
            throw new DuplicateResourceException(
                    "category name already exist"
            );
        }

    // add
        Category category = new Category();
        category.setName(categoryRequest.name());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        checkIfCategoryExistsOrThrow(id);
        categoryRepository.deleteById(id);
    }
    private void checkIfCategoryExistsOrThrow(Long categoryId) {
        if(!categoryRepository.existsCategoryById(categoryId)) {
            throw  new ResourceNotFoundException(
                    "category with id [%s] not found".formatted(categoryId)
            );
        }
    }

    @Override
    public void updateCategory(Long id,CategoryRequest categoryRequest) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" category with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if(categoryRequest.name() != null && !categoryRequest.name().equals(category)) {
           category.setName(categoryRequest.name());
            changes = true;
        }

        if(!changes) {
            throw new RequestValidationException("no data changes found");
        }

        categoryRepository.save(category);
    }
}
