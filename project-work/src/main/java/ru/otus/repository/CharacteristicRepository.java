package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.Characteristic;

import java.util.UUID;

public interface CharacteristicRepository extends JpaRepository<Characteristic, UUID> {
}