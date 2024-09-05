package com.example.jpamapping.controller;

import com.example.jpamapping.model.Post;
import com.example.jpamapping.model.User;
import com.example.jpamapping.service.PostService;
import com.example.jpamapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.savePost(post);
        return ResponseEntity.ok(createdPost);
    }

    // Add new post and associate it with an existing user
    @PostMapping("/user/{userId}")
    public ResponseEntity<Post> createPostForUser(@PathVariable Long userId, @RequestBody Post post) {
        // Fetch the user by ID
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(404).body(null); // User not found
        }

        // Associate the post with the user
        post.setUser(user);

        // Save the post
        Post createdPost = postService.savePost(post);

        return ResponseEntity.ok(createdPost);
    }
}

