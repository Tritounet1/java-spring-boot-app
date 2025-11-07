package com.example.first_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.first_app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
