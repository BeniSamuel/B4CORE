package com.b4music.b4core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Reels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String path;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;


    public Reels (String name, String description, User author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }
}
