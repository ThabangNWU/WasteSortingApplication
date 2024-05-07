package com.enviro.assessment.grad001.LebeleThabangAdmore.repositories;

import com.enviro.assessment.grad001.LebeleThabangAdmore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findCategoryByName(String name);
    boolean existsCategoryByName(String name);
    boolean existsCategoryById(Long id);
}
