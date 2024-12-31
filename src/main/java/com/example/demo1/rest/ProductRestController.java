package com.example.demo1.rest;

import java.util.List;

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

import com.example.demo1.Product;
import com.example.demo1.service.ProductService;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    // Get a product by ID
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Get all products
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    // Update an existing product
    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    // Delete a product by ID
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
        String status = productService.deleteById(id);
        if ("Not Found".equals(status)) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
