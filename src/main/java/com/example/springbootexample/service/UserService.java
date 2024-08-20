package com.example.springbootexample.service;

import com.example.springbootexample.model.User;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<User> userList = new ArrayList<>();

    Long currentId = 1L;
    public User createUser(User user){
        user.setId(currentId++);
        userList.add(user);
        return user;
    }

    public List<User> getAllUser() {
        return userList;
    }

    public Optional<User> getUserById(Long userId) {
        return userList.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        return getUserById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            return user;
        });
    }
}
