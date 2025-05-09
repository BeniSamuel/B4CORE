package com.b4music.b4core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Playlists> playlistsList;

    public Library () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
