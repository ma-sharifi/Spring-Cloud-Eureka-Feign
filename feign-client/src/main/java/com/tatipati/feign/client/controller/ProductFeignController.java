package com.tatipati.feign.client.controller;

import com.tatipati.feign.client.feign.ProductServiceClient;
import com.tatipati.feign.client.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "fetch")
public class ProductFeignController {
    @Autowired
    ProductServiceClient productServiceClient;

    @GetMapping
    public ResponseEntity<?> fetchProducts() {

        return ResponseEntity.ok(productServiceClient.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchProduct(@PathVariable int id) {
        Product product = productServiceClient.getProduct(id);

        return ResponseEntity.ok(product);
    }

}