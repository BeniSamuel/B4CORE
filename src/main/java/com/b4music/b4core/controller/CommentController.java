package com.b4music.b4core.controller;

import com.b4music.b4core.model.Comment;
import com.b4music.b4core.service.CommentService;
import com.b4music.b4core.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/b4core/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllComments () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained all comments!!!", this.commentService.getAllComments()));
    }

    @GetMapping("/{commentsId}")
    public ResponseEntity<ApiResponse<Comment>> getCommentsById (@PathVariable Long commentsId) {
        Comment comment = this.commentService.getCommentById(commentsId);
        if (comment != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained comments!!!", comment));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to retrieve comment!!!", null));
    }

    @GetMapping("/user/{userId}/all")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllCommentsByUser (@PathVariable Long userId) {
        List<Comment> comments = this.commentService.getAllCommentByUser(userId);
        if (!comments.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained all comments by user!!!", comments));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to retrieve comments!!!", null));
    }

    @GetMapping("/playlist/{playlistId}/all")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllCommentsByPlaylist (@PathVariable Long playlistId) {
        List<Comment> comments = this.commentService.getAllCommentsByPlaylist(playlistId);
        if (!comments.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully retrieved all comments on playlist!!!", comments));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(true,"Failed to retrieve comments playlist not found!!!", null));
    }

    @GetMapping("/music/{musicId}/all")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllCommentsByMusic (@PathVariable Long musicId) {
        List<Comment> comments = this.commentService.getAllCommentsByMusic(musicId);
        if (!comments.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully retrieved all comments on music", comments));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to retrieve comments on music", null));
    }

    @GetMapping("/reel/{reelId}/all")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllCommentsByReel (@PathVariable Long reelId) {
        List<Comment> comments = this.commentService.getAllCommentsByReels(reelId);
        if (!comments.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully retrieved all comments on reels", comments));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to retrieve all comments on reel", null));
    }
}
