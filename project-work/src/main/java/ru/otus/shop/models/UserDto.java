package ru.otus.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String login;
    private String password; // Обратите внимание, что пароль не должен возвращаться в ответах API
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
