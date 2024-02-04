package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.Basket;

import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, UUID> {
}