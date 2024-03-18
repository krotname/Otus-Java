package ru.otus.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.otus.shop.entities.Category;
import ru.otus.shop.models.CategoryDto;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);
}