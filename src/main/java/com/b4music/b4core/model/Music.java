package com.b4music.b4core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    private Long likes;
    private Long dislikes;

    @OneToMany
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Music () {}

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public User getUser() {
        return user;
    }

    public Long getLikes() {
        return likes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
