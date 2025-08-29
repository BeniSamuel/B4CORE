package com.b4music.b4core.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlaylistDto {
    private String title;
    private Long user_id;
    private final LocalDateTime created_at = LocalDateTime.now();
}
