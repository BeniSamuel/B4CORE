package com.b4music.b4core.repository;

import com.b4music.b4core.model.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistsRepository extends JpaRepository<Playlists, Long> {
}
