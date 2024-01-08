package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}