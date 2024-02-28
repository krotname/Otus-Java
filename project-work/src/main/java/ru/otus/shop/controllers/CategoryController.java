package ru.otus.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.models.CategoriesDto;
import ru.otus.shop.models.CategoryDto;
import ru.otus.shop.services.CategoryService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Категории", description = "Управление категориями товаров")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Получить список всех категорий", description = "Возвращает список категорий товаров")
    @ApiResponse(responseCode = "200", description = "Успешное получение списка категорий",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class))})
    @GetMapping
    public CategoriesDto getAllCategories() {
        return new CategoriesDto(categoryService.findAllCategories());
    }

    @Operation(summary = "Получить категорию по ID", description = "Возвращает категорию по её идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Найдена категория",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Категория не найдена",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable @Parameter(description = "ID категории, которую нужно найти") UUID id) {
        return categoryService.findCategoryById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Создать новую категорию", description = "Создает новую категорию с указанными данными")
    @ApiResponse(responseCode = "201", description = "Категория успешно создана",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoryDto.class))})
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить категорию", description = "Обновляет категорию с указанным ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Категория обновлена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Категория не найдена",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Удалить категорию", description = "Удаляет категорию с указанным ID")
    @ApiResponse(responseCode = "204", description = "Категория удалена",
            content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
