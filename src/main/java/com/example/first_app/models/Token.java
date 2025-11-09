package com.example.first_app.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String token;

    private LocalDateTime createdAt;

    public Token() {
        this.createdAt = LocalDateTime.now();
    }

    public Token(User user, String token) {
        this.user = user;
        this.token = token;
        this.createdAt = LocalDateTime.now();
    }
}
