package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}