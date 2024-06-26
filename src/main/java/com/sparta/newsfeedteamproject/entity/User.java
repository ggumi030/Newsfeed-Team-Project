package com.sparta.newsfeedteamproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
@RequiredArgsConstructor
public class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, name = "username")
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "user_info")
    private String userInfo;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "refresh_token")
    private String refreshToken;

    public User(String username, String password, String name, String email, String userInfo, Status status) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.userInfo = userInfo;
        this.status = status;
    }

    public void deleteRefreshToken() {
        this.refreshToken = "";
    }

    public void update(String name, String userInfo, String newPassword) {
        this.name = name;
        this.userInfo = userInfo;
        this.password = newPassword;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
