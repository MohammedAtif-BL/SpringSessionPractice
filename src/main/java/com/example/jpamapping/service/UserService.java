package com.example.jpamapping.service;

import com.example.jpamapping.model.User;
import com.example.jpamapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
