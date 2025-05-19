package com.b4music.b4core.repository;

import com.b4music.b4core.model.Music;
import com.b4music.b4core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    Music getMusicById(Long id);
    List<Music> getMusicByUser(User user);
}
