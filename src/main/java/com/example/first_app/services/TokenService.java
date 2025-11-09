package com.example.first_app.services;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_app.models.Token;
import com.example.first_app.models.User;
import com.example.first_app.repositories.TokenRepository;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    private String generateSecureToken() {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        String newToken;
        do {
            byte[] randomBytes = new byte[24];
            secureRandom.nextBytes(randomBytes);
            newToken = encoder.encodeToString(randomBytes);
        } while (tokenRepository.findByToken(newToken).isPresent());

        return newToken;
    }

    public String createToken(User user) {
        Optional<Token> existingToken = tokenRepository.findByUserId(user.getId());

        if (existingToken.isPresent()) {
            return existingToken.get().getToken();
        }
        Token newToken = new Token(user, generateSecureToken());

        return tokenRepository.save(newToken).getToken();
    }

}
