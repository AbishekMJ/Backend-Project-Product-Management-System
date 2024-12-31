package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Product;
import com.example.demo1.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public String upsert(Product product) {
        productRepo.save(product); // Correct repository usage
        return "Product saved successfully with ID: " + product.getId();
    }

    @Override
    public Product getById(Integer id) { // Changed to Integer
        return productRepo.findById(id).orElse(null); // Simplified Optional handling
    }

    @Override
    public List<Product> getAllProducts() { // Correct method name
        return productRepo.findAll();
    }

    @Override
    public String deleteById(Integer id) { // Changed to Integer
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id); // Correct repository usage
            return "Product successfully deleted.";
        } else {
            return "No product found with ID: " + id;
        }
    }
}
