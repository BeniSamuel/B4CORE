package com.b4music.b4core.dto;

import com.b4music.b4core.enums.Role;
import lombok.Getter;

@Getter
public class UserRegisterDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
