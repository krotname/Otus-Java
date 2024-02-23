package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.shop.entities.User;
import ru.otus.shop.models.UserDto;
import ru.otus.shop.repositories.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    @Transactional
    public UserDto registerUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getLogin(), null, savedUser.getFirstName(),
                savedUser.getLastName(), savedUser.getEmail(), savedUser.getPhone());
    }

    @Override
    @Transactional
    public UserDto loginUser(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByLogin(userDto.getLogin())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDto(user.getId(), user.getLogin(), null, user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPhone());
    }

    @Override
    @Transactional
    public UserDto updateUser(UUID id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        User updatedUser = userRepository.save(user);
        return new UserDto(updatedUser.getId(), updatedUser.getLogin(), null, updatedUser.getFirstName(),
                updatedUser.getLastName(), updatedUser.getEmail(), updatedUser.getPhone());
    }
}

