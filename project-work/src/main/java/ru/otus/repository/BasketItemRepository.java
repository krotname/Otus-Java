package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.BasketItem;
import ru.otus.entity.BasketItemId;

public interface BasketItemRepository extends JpaRepository<BasketItem, BasketItemId> {
}