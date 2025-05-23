package com.b4music.b4core.service;

import com.b4music.b4core.model.Music;
import com.b4music.b4core.model.User;
import com.b4music.b4core.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;
    private final UserService userService;
    private final FileService fileService;

    public MusicService (MusicRepository musicRepository, UserService userService, FileService fileService) {
        this.musicRepository = musicRepository;
        this.userService = userService;
        this.fileService = fileService;
    }

    public List<Music> getAllMusic () {
        return this.musicRepository.findAll();
    }

    public List<Music> getAllMusicByUser (Long userId) {
        User user = this.userService.getUserById(userId);
        if (user != null) {
            return this.musicRepository.getMusicByUser(user);
        }
        return null;
    }

    public Music getMusicById (Long musicId) {
        return this.musicRepository.getMusicById(musicId);
    }
}
