package com.example.first_app;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Collection<User> users = new ArrayList<>();

    public Collection<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Boolean userAlreadyExist(User newUser) {
        for (User user : users) {
            if (user.getEmail().equals(newUser.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
