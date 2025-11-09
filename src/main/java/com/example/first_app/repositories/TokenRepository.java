package com.example.first_app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first_app.models.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByUserId(Long userId);

    Optional<Token> findByToken(String token);

}
