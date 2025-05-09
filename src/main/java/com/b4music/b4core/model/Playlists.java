package com.b4music.b4core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Playlists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany
    private List<Music> music;
    private Long likes;
    private Long dislikes;

    @OneToMany
    private List<Comment> comments;

    public Playlists () {}

    public String getTitle () {
        return this.title;
    }

    public List<Music> getMusic () {
        return this.music;
    }

    public Long getLikes () {
        return this.likes;
    }

    public Long getDislikes () {
        return this.dislikes;
    }

    public List<Comment> getComments () {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public void addMusic (Music music) {
        this.music.add(music);
    }
}
