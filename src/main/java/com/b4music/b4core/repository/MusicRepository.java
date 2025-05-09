package com.b4music.b4core.repository;

import com.b4music.b4core.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
