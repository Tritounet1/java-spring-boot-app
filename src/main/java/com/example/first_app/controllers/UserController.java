package com.example.first_app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_app.models.User;
import com.example.first_app.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getId(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public String createResource(@RequestBody User user) {
        user.setId(userService.getUsers().size());
        if (userService.userAlreadyExist(user)) {
            return "User not created, this email is already used.";
        }
        userService.addUser(user);
        return "New user created.";
    }
}
