package ru.otus.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriesDto {
    private List<CategoryDto> categories;
}
