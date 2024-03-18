package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<CategoryDto> findCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::categoryToCategoryDto);
    }

    @Override
    @Transactional
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        var category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);
        var savedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
    }

    @Override
    @Transactional
    public Optional<CategoryDto> updateCategory(UUID id, CategoryDto categoryDto) {
        return categoryRepository.findById(id).map(existingCategory -> {
            var updatedCategory = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);
            updatedCategory.setId(existingCategory.getId());
            var savedCategory = categoryRepository.save(updatedCategory);
            return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
        });
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}
