package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.shop.mappers.CategoryMapper;
import ru.otus.shop.models.CategoryDto;
import ru.otus.shop.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDto> findCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::categoryToCategoryDto);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        var category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);
        var savedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
    }

    @Override
    public Optional<CategoryDto> updateCategory(UUID id, CategoryDto categoryDto) {
        return categoryRepository.findById(id).map(existingCategory -> {
            var updatedCategory = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);
            updatedCategory.setId(existingCategory.getId());
            var savedCategory = categoryRepository.save(updatedCategory);
            return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
        });
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}
