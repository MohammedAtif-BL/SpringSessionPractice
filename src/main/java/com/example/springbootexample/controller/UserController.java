package com.example.springbootexample.controller;

import com.example.springbootexample.model.User;
import com.example.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getall")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/getbyid/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody User user){
        Optional<User> userData = userService.updateUser(id, user);
        return userData.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
