package com.internflow.internflow_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internflow.internflow_backend.dto.LoginRequest;
import com.internflow.internflow_backend.dto.RegisterRequest;
import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody RegisterRequest request) {
        return userService.registerUser(
            request.getFullname(),
            request.getEmail(),
            request.getPassword(),
            request.getRole());
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return userService.loginUser(
            request.getEmail(),
            request.getPassword());
    }
    
    
   
}
