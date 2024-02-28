package ru.otus.shop.models;

import lombok.Data;
import ru.otus.shop.entities.User;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    private User user;
    private String description;
    private OffsetDateTime createdAt;
}
