package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}