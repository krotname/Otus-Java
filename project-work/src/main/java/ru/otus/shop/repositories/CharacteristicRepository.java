package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.Characteristic;

import java.util.UUID;

public interface CharacteristicRepository extends JpaRepository<Characteristic, UUID> {
}