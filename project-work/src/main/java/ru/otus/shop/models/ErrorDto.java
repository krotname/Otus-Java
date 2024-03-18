package ru.otus.shop.models;

import lombok.*;

import java.time.LocalDateTime;

@Value
public class ErrorDto {
    String message;
    LocalDateTime time;

    public ErrorDto(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }
}
