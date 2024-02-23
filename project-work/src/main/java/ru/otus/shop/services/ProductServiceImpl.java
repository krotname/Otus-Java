package ru.otus.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.shop.entities.Product;
import ru.otus.shop.mappers.ProductMapper;
import ru.otus.shop.models.ProductDto;
import ru.otus.shop.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<ProductDto> findProductById(UUID id) {
        return productRepository.findById(id)
                .map(ProductMapper.INSTANCE::productToProductDto);
    }

    @Override
    @Transactional
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDto(savedProduct);
    }

    @Override
    @Transactional
    public Optional<ProductDto> updateProduct(UUID id, ProductDto productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setPrice(BigDecimal.valueOf(productDetails.getPrice()));
                    return ProductMapper.INSTANCE.productToProductDto(productRepository.save(product));
                });
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}