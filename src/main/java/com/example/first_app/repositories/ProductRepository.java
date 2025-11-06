package com.example.first_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.first_app.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // Product findById(long id);
}
