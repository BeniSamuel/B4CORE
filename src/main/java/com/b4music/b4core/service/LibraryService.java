package com.b4music.b4core.service;

import com.b4music.b4core.model.Library;
import com.b4music.b4core.repository.LibraryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService (LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibraries () {
        return this.libraryRepository.findAll();
    }

    public Page<Library> getAllLibrariesPaginated (int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.libraryRepository.findAll(pageable);
    }

    public Library getLibraryById (Long libraryId) {
        return this.libraryRepository.getLibraryById(libraryId);
    }
}
