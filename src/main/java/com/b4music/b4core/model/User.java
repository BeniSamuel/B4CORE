package com.b4music.b4core.model;

import com.b4music.b4core.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany
    private List<Playlists> playlists = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    private List<Comment> comments;
    private List<Music> musics;
    private List<Reels> reels;

    public User () {}
    public User (String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public Role getRole () { return this.role; }
    public List<Playlists> getPlaylists() {
        return this.playlists;
    }
    public List<Comment> getComments() {
        return this.comments;
    }
    public List<Music> getMusics () {
        return this.musics;
    }
    public List<Reels> getReels() {
        return reels;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPlaylists(List<Playlists> playlists) {
        this.playlists = playlists;
    }

    public void setReels(List<Reels> reels) {
        this.reels = reels;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
