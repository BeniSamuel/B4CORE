package com.b4music.b4core.service;

import com.b4music.b4core.model.Reels;
import com.b4music.b4core.model.User;
import com.b4music.b4core.repository.ReelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelService {
    private final ReelsRepository reelsRepository;
    private final UserService userService;

    public ReelService (ReelsRepository reelsRepository, UserService userService) {
        this.reelsRepository = reelsRepository;
        this.userService = userService;
    }

    public List<Reels> getAllReels () {
        return this.reelsRepository.findAll();
    }

    public List<Reels> getAllReelsByUser (Long userId) {
        User user = this.userService.getUserById(userId);
        if (user != null) {
            return this.reelsRepository.getReelsByUser(user);
        }
        return null;
    }
}
