package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.ShopInfo;

import java.util.UUID;

public interface ShopInfoRepository extends JpaRepository<ShopInfo, UUID> {
}