package com.b4music.b4core.service;

import com.b4music.b4core.dto.UserRegisterDto;
import com.b4music.b4core.model.User;
import com.b4music.b4core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    public List<User> getUsersByEmail (String email) {
        return this.userRepository.getUsersByEmail(email);
    }

    public Page<User> getAllUsersPaginated (int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.userRepository.findAll(pageable);
    }

    public User getUserById (Long id) {
        return this.userRepository.getUserById(id).orElse(null);
    }

    public User getUserByEmail (String email) {
        return this.userRepository.getUserByEmail(email).orElse(null);
    }

    public User createUser (UserRegisterDto userRegisterDto) {
        User newUser = new User(userRegisterDto.getName(), userRegisterDto.getEmail(), passwordEncoder.encode(userRegisterDto.getPassword()), userRegisterDto.getRole());
        return this.userRepository.save(newUser);
    }

    public User updateUserById (Long id, UserRegisterDto userRegisterDto) {
        User user = this.getUserById(id);
        if (user != null) {
            user.setName(userRegisterDto.getName());
            user.setEmail(userRegisterDto.getEmail());
            user.setPassword(userRegisterDto.getPassword());
            user.setPhone(user.getPhone());
            user.setRole(userRegisterDto.getRole());

            return this.userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUserById (Long id) {
        User user = this.getUserById(id);
        if (user != null) {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
