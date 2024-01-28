package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.otus.entity.Basket;

import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, UUID> {
}