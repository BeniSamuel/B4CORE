package com.b4music.b4core.model;

import jakarta.persistence.*;

@Entity
public class Playlists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long likes;
    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Playlists () {}
    public Playlists (String title, Long likes, Long dislikes) {
        this.title = title;
        this.likes = likes;
        this.dislikes = likes;
    }

    public String getTitle () {
        return this.title;
    }

    public Long getLikes () {
        return this.likes;
    }

    public Long getDislikes () {
        return this.dislikes;
    }

    public User getUser () { return this.user; }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser (User user) { this.user = user; }


}
