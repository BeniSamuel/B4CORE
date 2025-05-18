package com.b4music.b4core.dto;

public class ReelDto {
    private String name;
    private String description;
    private Long likes;
    private Long dislikes;
    private Long user_id;

    public String getName () { return this.name; }
    public String getDescription () { return this.description; }
    public Long getLikes () { return this.likes; }
    public Long getDislikes () { return this.dislikes; }
    public Long getUser_id () { return this.user_id; }
}
