package ru.otus.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.exceptions.NotFoundException;
import ru.otus.shop.models.ProductDto;
import ru.otus.shop.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Товары", description = "Управление товарами")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Получить список всех товаров", description = "Возвращает список всех товаров")
    @ApiResponse(responseCode = "200", description = "Успешное получение списка товаров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)))
    @GetMapping
    public List<ProductDto> getAllProducts() {
        log.info("Запрос на получение списка всех товаров");
        return productService.findAllProducts();
    }

    @Operation(summary = "Получить товар по ID", description = "Возвращает товар по его идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Товар не найден",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") @Parameter(description = "ID товара, который нужно найти") UUID id) {
        log.info("Запрос на получение товара с id: {}", id);
        return productService.findProductById(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseThrow(() -> new NotFoundException("Товар не найден"));
    }

    @Operation(summary = "Создать новый товар", description = "Создает новый товар с указанными данными")
    @ApiResponse(responseCode = "201", description = "Товар успешно создан",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)))
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Parameter(description = "Данные нового товара") ProductDto productDto) {
        log.info("Запрос на создание нового товара");
        ProductDto createdProduct = productService.saveProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить существующий товар", description = "Обновляет данные товара с указанным ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар обновлен",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Товар для обновления не найден",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") UUID id, @RequestBody @Parameter(description = "Новые данные товара") ProductDto productDto) {
        log.info("Запрос на обновление товара с id: {}", id);
        return productService.updateProduct(id, productDto)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseThrow(() -> new NotFoundException("Товар для обновления не найден"));
    }

    @Operation(summary = "Удалить товар", description = "Удаляет товар с указанным ID")
    @ApiResponse(responseCode = "204", description = "Товар удален",
            content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") UUID id) {
        log.info("Запрос на удаление товара с id: {}", id);
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
