package com.example.first_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first_app.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
