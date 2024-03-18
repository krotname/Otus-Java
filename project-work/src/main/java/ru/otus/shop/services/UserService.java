package ru.otus.shop.services;


import ru.otus.shop.models.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    UserDto loginUser(UserDto userDto);
    UserDto updateUser(UUID id, UserDto userDto);
}