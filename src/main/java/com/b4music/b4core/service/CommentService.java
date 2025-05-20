package com.b4music.b4core.service;

import com.b4music.b4core.dto.CommentDto;
import com.b4music.b4core.model.*;
import com.b4music.b4core.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PlayListService playListService;
    private final ReelService reelService;
    private final MusicService musicService;
    private final LibraryService libraryService;

    public CommentService (CommentRepository commentRepository, UserService userService, PlayListService playListService, ReelService reelService, MusicService musicService, LibraryService libraryService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.playListService = playListService;
        this.reelService = reelService;
        this.musicService = musicService;
        this.libraryService = libraryService;
    }

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

    public List<Comment> getAllCommentsByLibrary (Long libraryId) {
        Library library = this.libraryService.getLibraryById(libraryId);
        if (library != null) {
            return this.commentRepository.getCommentsByLibrary(library);
        }
        return null;
    }

    public Comment getCommentById (Long commentId) {
        return this.commentRepository.getCommentsById(commentId);
    }

    public Comment createCommentByReel (Long reelId, CommentDto commentDto) {
        Reels reel = this.reelService.getReelsById(reelId);
        if (reel != null) {
            Comment newComment = new Comment(commentDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), reel);
            return this.commentRepository.save(newComment);
        }
        return null;
    }

    public Comment createCommentByMusic (Long musicId, CommentDto commentDto) {
        Music music = this.musicService.getMusicById(musicId);
        if (music != null) {
            Comment newComment = new Comment(commentDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), music);
            return this.commentRepository.save(newComment);
        }
        return null;
    }

    public Comment createCommentByPlaylist (Long playlistId, CommentDto commentDto) {
        Playlists playlists = this.playListService.getPlaylistById(playlistId);
        if (playlists != null) {
            Comment newComment = new Comment(commentDto.getMessage(), commentDto.getLikes(), commentDto.getDislikes(), playlists);
            return this.commentRepository.save(newComment);
        }
        return null;
    }
}
