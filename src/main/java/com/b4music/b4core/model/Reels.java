package com.b4music.b4core.model;

import jakarta.persistence.*;

@Entity
public class Reels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private Long likes;
    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reels () {}
    public Reels (String name, String description, Long likes, Long dislikes, User user) {
        this.name = name;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.user = user;
    }

    public String getName() {
        return name;
    }
    public Long getDislikes() {
        return dislikes;
    }
    public String getDescription() {
        return description;
    }
    public Long getLikes() {
        return likes;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLikes(Long likes) {
        this.likes = likes;
    }
    public void setDislikes (Long dislikes) {
        this.dislikes = dislikes;
    }
}
