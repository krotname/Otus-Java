package ru.otus.shop.services;


import ru.otus.shop.models.CategoryDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDto> findAllCategories();
    Optional<CategoryDto> findCategoryById(UUID id);
    CategoryDto saveCategory(CategoryDto categoryDto);
    Optional<CategoryDto> updateCategory(UUID id, CategoryDto categoryDto);
    void deleteCategory(UUID id);
}
