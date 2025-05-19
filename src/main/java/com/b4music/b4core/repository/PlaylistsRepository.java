package com.b4music.b4core.repository;

import com.b4music.b4core.model.Playlists;
import com.b4music.b4core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistsRepository extends JpaRepository<Playlists, Long> {
    Playlists getPlaylistsById (Long id);
    Playlists getPlaylistsByTitle(String title);
    List<Playlists> getPlaylistsByUser(User user);
}
