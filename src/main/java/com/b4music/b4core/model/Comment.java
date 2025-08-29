package com.b4music.b4core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @ManyToOne
    @JoinColumn(name = "playlists_id")
    private Playlists playlists;

    @ManyToOne
    @JoinColumn(name = "reels_id")
    private Reels reels;

    public Comment (String message, Reels reels, User author) {
        this.message = message;
        this.reels = reels;
        this.author = author;
    }
    public Comment (String message, Music music, User author) {
        this.message = message;
        this.music = music;
        this.author = author;
    }
    public Comment (String message, Playlists playlists, User author) {
        this.message = message;
        this.playlists = playlists;
        this.author = author;
    }
}
