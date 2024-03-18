package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findAllByUserId(UUID uuid);
}