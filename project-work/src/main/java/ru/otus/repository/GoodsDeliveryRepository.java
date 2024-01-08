package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.GoodsDelivery;

import java.util.UUID;

public interface GoodsDeliveryRepository extends JpaRepository<GoodsDelivery, UUID> {
}