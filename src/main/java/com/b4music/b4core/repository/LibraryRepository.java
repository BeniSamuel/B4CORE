package com.b4music.b4core.repository;

import com.b4music.b4core.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library getLibraryById(Long id);
}
