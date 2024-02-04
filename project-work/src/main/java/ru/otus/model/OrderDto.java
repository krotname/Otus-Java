package ru.otus.model;

import ru.otus.entity.User;

import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    private User user;
    private String description;
    private OffsetDateTime createdAt;
}
