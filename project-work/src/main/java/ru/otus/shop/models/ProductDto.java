package ru.otus.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.shop.entities.Category;
import ru.otus.shop.entities.Characteristic;
import ru.otus.shop.entities.Measure;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private UUID id;
    private String name;
    private double price;
    private Long quantity;
    private String photo;
    private CategoryDto category;
    private Measure measure;
}
