package com.b4music.b4core.repository;

import com.b4music.b4core.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByUser(User user);
    List<Comment> getCommentsByPlaylists(Playlists playlists);
    List<Comment> getCommentsByReels(Reels reels);
    List<Comment> getCommentsByLibrary(Library library);
    List<Comment> getCommentsByMusic(Music music);
}
