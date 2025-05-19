package com.b4music.b4core.service;

import com.b4music.b4core.dto.PlaylistDto;
import com.b4music.b4core.model.Playlists;
import com.b4music.b4core.model.User;
import com.b4music.b4core.repository.PlaylistsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {
    private final PlaylistsRepository playlistsRepository;
    private final UserService userService;

    public PlayListService (PlaylistsRepository playlistsRepository, UserService userService) {
        this.playlistsRepository = playlistsRepository;
        this.userService = userService;
    }

    public List<Playlists> getAllPlaylists () {
        return this.playlistsRepository.findAll();
    }

    public List<Playlists> getAllPlayListsByUser (Long userId) {
        User user = this.userService.getUserById(userId);
        if (user != null) {
            return this.playlistsRepository.getPlaylistsByUser(user);
        }
        return null;
    }

    public Page<Playlists> getAllPlaylistsPaginated (int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.playlistsRepository.findAll(pageable);
    }

    public Page<Playlists> getAllPlaylistsByUserPaginated (int page, int size, String sortBy, Long userId) {
        User user = this.userService.getUserById(userId);
        if (user != null) {
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
            return this.playlistsRepository.findAll(pageable);
        }
        return null;
    }

    public Playlists getPlaylistById (Long playListId) {
        return this.playlistsRepository.getPlaylistsById(playListId);
    }

    public Playlists getPlaylistByName (String name) {
        return this.playlistsRepository.getPlaylistsByTitle(name);
    }

    public Playlists createPlaylist (PlaylistDto playlistDto) {
        Playlists playlists = new Playlists(playlistDto.getTitle(), playlistDto.getLikes(), playlistDto.getDisLikes());
        return this.playlistsRepository.save(playlists);
    }

    public Playlists updatePlaylistById (Long playListId, PlaylistDto playlistDto) {
        Playlists playlists = this.getPlaylistById(playListId);
        if (playlists != null) {
            playlists.setTitle(playlistDto.getTitle());
            playlists.setLikes(playlistDto.getDisLikes());
            playlists.setDislikes(playlistDto.getDisLikes());

            return this.playlistsRepository.save(playlists);
        }
        return null;
    }

    public Boolean deletePlaylistById (Long playlistId) {
        Playlists playlists = this.getPlaylistById(playlistId);
        if (playlists != null) {
            this.playlistsRepository.delete(playlists);
            return true;
        }
        return false;
    }
}
