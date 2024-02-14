package ru.otus.shop.services;


import ru.otus.shop.models.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<ProductDto> findAllProducts();

    Optional<ProductDto> findProductById(UUID id);

    ProductDto saveProduct(ProductDto productDto);

    Optional<ProductDto> updateProduct(UUID id, ProductDto productDetails);

    void deleteProduct(UUID id);
}
