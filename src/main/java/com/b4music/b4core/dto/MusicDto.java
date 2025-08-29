package com.b4music.b4core.dto;

import java.time.LocalDateTime;

public class MusicDto {
    private String name;
    private String description;
    private Long user_id;
    private final LocalDateTime added_at = LocalDateTime.now();
}
