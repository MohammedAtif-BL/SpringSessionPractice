package com.example.jpamapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection
//    @CollectionTable(name = "phone_table",joinColumns =)
    private List<String> phone;

    private String password;

    // One user can have many posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);  // Set the user for each post
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setUser(null);
    }
}
