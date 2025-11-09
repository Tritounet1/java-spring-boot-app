package com.example.first_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_app.models.User;
import com.example.first_app.repositories.UserRepository;
import com.example.first_app.services.TokenService;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getId(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return "User already exist with this email";
        }

        existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return "User already exist with this username";
        }

        User savedUser = userRepository.saveAndFlush(user);
        return tokenService.createToken(savedUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody User searchUser) {
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(searchUser.getUsername())
                    && user.getPassword().equals(searchUser.getPassword())) {
                return tokenService.createToken(user);
            }
        }
        return "no user found.";
    }

}
