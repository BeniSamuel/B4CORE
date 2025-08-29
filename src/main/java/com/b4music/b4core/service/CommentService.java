package com.b4music.b4core.service;

import com.b4music.b4core.dto.CommentMusicDto;
import com.b4music.b4core.model.*;
import com.b4music.b4core.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PlayListService playListService;
    private final ReelService reelService;
    private final MusicService musicService;

    public List<Comment> getAllComments () {
        return this.commentRepository.findAll();
    }

    public List<Comment> getAllCommentByUser (Long userId) {
        User user = this.userService.getUserById(userId);
        if (user != null) {
            return this.commentRepository.getCommentsByUser(user);
        }
        return null;
    }

    public List<Comment> getAllCommentsByPlaylist (Long playListId) {
        Playlists playlists = this.playListService.getPlaylistById(playListId);
        if (playlists != null) {
            return this.commentRepository.getCommentsByPlaylists(playlists);
        }
        return null;
    }

    public List<Comment> getAllCommentsByReels (Long reelId) {
        Reels reels = this.reelService.getReelsById(reelId);
        if (reels != null) {
            return this.commentRepository.getCommentsByReels(reels);
        }
        return null;
    }

    public List<Comment> getAllCommentsByMusic (Long musicId) {
        Music music = this.musicService.getMusicById(musicId);
        if (music != null) {
            return this.commentRepository.getCommentsByMusic(music);
        }
        return null;
    }

    public Comment getCommentById (Long commentId) {
        return this.commentRepository.getCommentsById(commentId);
    }

    public Comment createCommentByReel (Long reelId, CommentMusicDto commentDto) {
        Reels reel = this.reelService.getReelsById(reelId);
        if (reel != null) {
            Comment newComment = new Comment(commentDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), reel);
            return this.commentRepository.save(newComment);
        }
        return null;
    }

    public Comment createCommentByMusic (Long musicId, CommentMusicDto commentMusicDto) {
        Music music = this.musicService.getMusicById(musicId);
        if (music != null) {
            Comment newComment = new Comment(commentMusicDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), music);
            return this.commentRepository.save(newComment);
        }
        return null;
    }

    public Comment createCommentByPlaylist (Long playlistId, CommentMusicDto commentDto) {
        Playlists playlists = this.playListService.getPlaylistById(playlistId);
        if (playlists != null) {
            Comment newComment = new Comment(commentDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), playlists);
            return this.commentRepository.save(newComment);
        }
        return null;
    }
}
