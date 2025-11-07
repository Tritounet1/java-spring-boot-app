package com.example.first_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Username name cannot be null")
    @NotBlank(message = "Username name cannot be blank")
    private String username;

    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Password name cannot be null")
    @NotBlank(message = "Password name cannot be blank")
    private String password;

    public User() {
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
