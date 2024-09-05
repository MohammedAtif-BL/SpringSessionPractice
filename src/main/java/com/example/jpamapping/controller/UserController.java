package com.example.jpamapping.controller;

import com.example.jpamapping.model.Post;
import com.example.jpamapping.model.User;
import com.example.jpamapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Set the user for each post
        if (user.getPosts() != null) {
            for (Post post : user.getPosts()) {
                post.setUser(user); // Set the user for each post
            }
        }

        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}

