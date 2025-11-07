package com.example.first_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_app.exceptions.ResourceNotFoundException;
import com.example.first_app.models.Product;
import com.example.first_app.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductWithId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductsWithId(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok("Product delete");
                })
                .orElseGet(() -> {
                    throw new ResourceNotFoundException("No product with the id : " + id);
                });
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());

                    Product updated = productRepository.save(product);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    throw new ResourceNotFoundException("No product with the id : " + id);
                });
    }

    @PostMapping("/products")
    public ResponseEntity<Product> postProducts(@Valid @RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
