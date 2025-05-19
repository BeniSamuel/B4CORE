package com.b4music.b4core.dto;

public class PlaylistDto {
    private String title;
    private Long likes;
    private Long disLikes;

    public String getTitle () { return this.title; }
    public Long getLikes () { return this.likes; }
    public Long getDisLikes () { return this.disLikes; }
}
