package com.internflow.internflow_backend.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.AuthResponse;
import com.internflow.internflow_backend.entity.Role;
import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.exception.EmailAlreadyExistsException;
import com.internflow.internflow_backend.exception.InvalidCredentialsException;
import com.internflow.internflow_backend.repository.UserRepository;
import com.internflow.internflow_backend.security.JwtService;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid Credentials!"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid Credentials!");
        }
        String token = jwtService.generateToken(user.getId(), user.getRole());
        return new AuthResponse(token);
    }

    public User registerUser(String fullname, String email, String password, Role role) {
        Optional<User> existingUsers = userRepository.findByEmail(email);
        if (existingUsers.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User newUser = new User(fullname, email, hashedPassword, role);
        return userRepository.save(newUser);
    }

}
