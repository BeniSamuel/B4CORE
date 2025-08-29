package com.b4music.b4core.controller;

import com.b4music.b4core.dto.ReelDto;
import com.b4music.b4core.model.Reels;
import com.b4music.b4core.service.ReelService;
import com.b4music.b4core.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/b4core/v1/reels")
@AllArgsConstructor
public class ReelsController {
    private final ReelService reelService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Reels>>> getAllReels () {
        return ResponseEntity.ok(new ApiResponse<>(true,"Successfully obtained all reels!!!", this.reelService.getAllReels()));
    }

    @GetMapping("/{reelId}")
    public ResponseEntity<ApiResponse<Reels>> getReelById (@PathVariable Long reelId) {
        Reels reels = this.reelService.getReelsById(reelId);
        if (reels != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained a reel!!!", reels));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to obtain reel not found!!!", null));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<Reels>>> getAllReelsByUser (@PathVariable Long userId) {
        List<Reels> reels = this.reelService.getAllReelsByUser(userId);
        if (!reels.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained all reels by user!!!", reels));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to obtained reels user doesn't exist", null));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Reels>> createReel (@RequestBody ReelDto reelDto) {
        Reels reel = this.reelService.createReel(reelDto);
        if (reel != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created a new reel!!!", reel));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to create a new reel bad request!!!", null));
    }

    @PutMapping("/update/{reelId}")
    public ResponseEntity<ApiResponse<Reels>> updateReelById (@PathVariable Long reelId, @RequestBody ReelDto reelDto) {
        Reels reels = this.reelService.updateReel(reelId, reelDto);
        if (reels != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully updated reel!!!", reels));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to update reel not found!!!", null));
    }

    @DeleteMapping("/delete/{reelId}")
    public ResponseEntity<ApiResponse<Boolean>> deleteReelById (@PathVariable Long reelId) {
        return this.reelService.deleteReel(reelId) ?
                ResponseEntity.ok(new ApiResponse<>(true, "Successfully deleted reel!!!", true)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to delete reel!!!", false));
    }
}
