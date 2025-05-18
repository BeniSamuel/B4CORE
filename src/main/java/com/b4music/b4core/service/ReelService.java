package com.b4music.b4core.service;

import com.b4music.b4core.dto.ReelDto;
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

    public Reels getReelsById (Long id) {
        return this.reelsRepository.getReelsById(id);
    }


    public Reels createReel (ReelDto reelDto) {
        User user = this.userService.getUserById(reelDto.getUser_id());
        if (user != null) {
            Reels newReels = new Reels(reelDto.getName(), reelDto.getDescription(), reelDto.getLikes(), reelDto.getDislikes(), user);
            return this.reelsRepository.save(newReels);
        }
        return null;
    }

    public Reels updateReel (Long id, ReelDto reelDto) {
        User user = this.userService.getUserById(reelDto.getUser_id());
        Reels reel = this.getReelsById(id);

        if (user != null && reel != null) {
            reel.setName(reelDto.getName());
            reel.setDescription(reelDto.getDescription());
            reel.setLikes(reelDto.getLikes());
            reel.setDislikes(reel.getDislikes());
            reel.setUser(user);

            return this.reelsRepository.save(reel);
        }
        return null;
    }

    public Boolean deleteReel (Long id) {
        Reels reels = this.getReelsById(id);
        if (reels != null) {
            this.reelsRepository.delete(reels);
            return true;
        }
        return false;
    }

}
