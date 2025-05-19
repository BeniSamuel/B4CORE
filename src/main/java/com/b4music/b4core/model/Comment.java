package com.b4music.b4core.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long likes;
    private Long dislikes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @ManyToOne
    @JoinColumn(name = "playlists_id")
    private Playlists playlists;

    @ManyToOne
    @JoinColumn(name = "reels_id")
    private Reels reels;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

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

    public Long getId() {
        return id;
    }

    public Library getLibrary() {
        return library;
    }

    public Music getMusic() {
        return music;
    }

    public Playlists getPlaylists() {
        return playlists;
    }

    public Reels getReels() {
        return reels;
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

    public void setMusic(Music music) {
        this.music = music;
    }

    public void setReels(Reels reels) {
        this.reels = reels;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
