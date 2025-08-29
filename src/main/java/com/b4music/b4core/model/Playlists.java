package com.b4music.b4core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Playlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cover;

    private String title;

    @OneToMany()
    private List<Music> musics;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Playlists (String title, String cover, User author) {
        this.title = title;
        this.cover = cover;
        this.author = author;
    }
}
