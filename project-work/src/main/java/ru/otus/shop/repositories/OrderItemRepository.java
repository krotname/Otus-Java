package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.OrderItem;
import ru.otus.shop.entities.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}