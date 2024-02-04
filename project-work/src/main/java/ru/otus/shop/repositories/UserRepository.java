package ru.otus.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.shop.entities.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}