package com.b4music.b4core.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long likes;
    private Long dislikes;

    public Comment () {}

    public User getUser() {
        return user;
    }

    public Long getLikes() {
        return likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public String getMessage () {
        return message;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public void setLikes (Long likes) {
        this.likes = likes;
    }

    public void setDislikes (Long dislikes) {
        this.dislikes = dislikes;
    }
}
