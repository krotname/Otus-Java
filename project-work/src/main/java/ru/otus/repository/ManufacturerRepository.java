package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.Manufacturer;

import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID> {
}