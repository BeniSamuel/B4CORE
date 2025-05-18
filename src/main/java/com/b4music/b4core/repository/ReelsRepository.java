package com.b4music.b4core.repository;

import com.b4music.b4core.model.Reels;
import com.b4music.b4core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReelsRepository extends JpaRepository<Reels, Long> {
    List<Reels> getReelsByUser (User user);
}
