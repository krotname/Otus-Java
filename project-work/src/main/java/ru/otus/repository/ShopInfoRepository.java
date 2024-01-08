package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.ShopInfo;

import java.util.UUID;

public interface ShopInfoRepository extends JpaRepository<ShopInfo, UUID> {
}