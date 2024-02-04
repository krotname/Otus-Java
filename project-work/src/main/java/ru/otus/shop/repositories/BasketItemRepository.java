package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.BasketItem;
import ru.otus.shop.entities.BasketItemId;

public interface BasketItemRepository extends JpaRepository<BasketItem, BasketItemId> {
}