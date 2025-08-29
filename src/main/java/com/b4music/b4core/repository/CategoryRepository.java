package com.b4music.b4core.repository;

import com.b4music.b4core.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
