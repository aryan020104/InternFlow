package com.internflow.internflow_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setFullname(updatedUser.getFullname());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
