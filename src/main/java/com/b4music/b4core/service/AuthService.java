package com.b4music.b4core.service;

import com.b4music.b4core.dto.UserLoginDto;
import com.b4music.b4core.dto.UserRegisterDto;
import com.b4music.b4core.model.User;
import com.b4music.b4core.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthService (UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    public User registerUser (UserRegisterDto userRegisterDto) {
        return this.userService.createUser(userRegisterDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Bad credentials!!!", "Bad credentials"));
        }
    }
}
