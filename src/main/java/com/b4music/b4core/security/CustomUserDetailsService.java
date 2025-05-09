package com.b4music.b4core.security;

import com.b4music.b4core.exception.NotFoundException;
import com.b4music.b4core.model.User;
import com.b4music.b4core.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService (UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getUserByEmail(username);
        if (user != null) {
            return new CustomUserDetails(user);
        }
        throw new NotFoundException("User not found!!!");
    }
}
