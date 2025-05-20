package com.b4music.b4core.dto;

public class CommentDto {
    private String message;
    private Long likes;
    private Long dislikes;

    public String getMessage () { return this.message; }
    public Long getLikes () { return this.likes; }
    public Long getDislikes () { return this.dislikes; }
}
