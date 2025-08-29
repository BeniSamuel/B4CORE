package com.b4music.b4core.service;

import com.b4music.b4core.dto.UserLoginDto;
import com.b4music.b4core.dto.UserRegisterDto;
import com.b4music.b4core.model.User;
import com.b4music.b4core.util.ApiResponse;
import com.b4music.b4core.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public User registerUser (UserRegisterDto userRegisterDto) {
        return this.userService.createUser(userRegisterDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );

            User user = this.userService.getUserByEmail(userLoginDto.getEmail());
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully logged in user!!!", jwtUtil.generateToken(user.getEmail())));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Bad credentials!!!", "Bad credentials"));
        }
    }
}
