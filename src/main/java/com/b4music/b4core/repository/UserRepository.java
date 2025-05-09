package com.b4music.b4core.repository;

import com.b4music.b4core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> getUserByEmail (String email);
   Optional<User> getUserBYId (Long id);
}
