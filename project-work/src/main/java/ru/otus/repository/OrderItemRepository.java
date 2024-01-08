package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.OrderItem;
import ru.otus.entity.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}