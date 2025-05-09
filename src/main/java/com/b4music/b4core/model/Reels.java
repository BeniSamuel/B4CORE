package com.b4music.b4core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @OneToMany
    private List<Comment> comments;
    private Long likes;
    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
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


    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

}
