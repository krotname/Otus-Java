package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.GoodsDelivery;

import java.util.UUID;

public interface GoodsDeliveryRepository extends JpaRepository<GoodsDelivery, UUID> {
}