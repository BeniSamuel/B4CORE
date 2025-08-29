package com.b4music.b4core.service;

import com.b4music.b4core.dto.ReelDto;
import com.b4music.b4core.model.Reels;
import com.b4music.b4core.model.User;
import com.b4music.b4core.repository.ReelsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReelService {
    private final ReelsRepository reelsRepository;
    private final UserService userService;

    public List<Reels> getAllReels () {
        return this.reelsRepository.findAll();
    }

    public List<Reels> getAllReelsByUser (Long userId) {
        User author = this.userService.getUserById(userId);
        if (author != null) {
            return this.reelsRepository.getReelsByUser(author);
        }
        return null;
    }

    public Reels getReelsById (Long id) {
        return this.reelsRepository.getReelsById(id);
    }

    public Reels createReel (ReelDto reelDto) {
        User author = this.userService.getUserById(reelDto.getUser_id());
        if (author != null) {
            Reels newReels = new Reels(reelDto.getName(), reelDto.getDescription(), author);
            return this.reelsRepository.save(newReels);
        }
        return null;
    }

    public Reels updateReel (Long id, ReelDto reelDto) {
        User author = this.userService.getUserById(reelDto.getUser_id());
        Reels reel = this.getReelsById(id);

        if (author != null && reel != null) {
            reel.setName(reelDto.getName());
            reel.setDescription(reelDto.getDescription());
            reel.setAuthor(author);

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
