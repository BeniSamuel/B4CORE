package com.b4music.b4core.model;

import com.b4music.b4core.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private int phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User () {}
    public User (String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public Role getRole () { return this.role; }
    public int getPhone () { return this.phone; }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone (int phone) {
        this.phone = phone;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
