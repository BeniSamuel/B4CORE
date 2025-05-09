package com.b4music.b4core.controller;

import com.b4music.b4core.dto.UserLoginDto;
import com.b4music.b4core.dto.UserRegisterDto;
import com.b4music.b4core.model.User;
import com.b4music.b4core.service.AuthService;
import com.b4music.b4core.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b4core/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<User>> registerUser (@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully registered user!!!", this.authService.registerUser(userRegisterDto)));
    }

    @PostMapping("/login-user")
    public ResponseEntity<ApiResponse<String>> loginUser (@RequestBody UserLoginDto userLoginDto) {
        return this.authService.loginUser(userLoginDto);
    }
}
