package com.example.first_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Product name cannot be null")
    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotNull(message = "Price cannot be null")
    private Double price;

    protected Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // TODO delete this after fix mvn clean install problem
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
