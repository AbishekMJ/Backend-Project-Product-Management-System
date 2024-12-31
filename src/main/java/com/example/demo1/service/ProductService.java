package com.example.demo1.service;

import java.util.List;

import com.example.demo1.Product;

public interface ProductService {

    // Method to create or update a product
    String upsert(Product product);

    // Method to retrieve a product by its ID
    Product getById(Integer id);

    // Method to retrieve all products
    List<Product> getAllProducts();

    // Method to delete a product by its ID
    String deleteById(Integer id);
}
