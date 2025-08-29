package com.b4music.b4core.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentMusicDto {
    private String message;
    private Long music_id;
    private Long user_id;
    private final LocalDateTime commented_at = LocalDateTime.now();
}
