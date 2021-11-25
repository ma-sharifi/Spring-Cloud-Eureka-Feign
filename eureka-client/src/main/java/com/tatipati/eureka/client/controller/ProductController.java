package com.tatipati.eureka.client.controller;

import com.tatipati.eureka.client.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    private static List<Product> productList = new ArrayList< >();
    static {
        productList.add(new Product(1, "product-1", 12.0));
        productList.add(new Product(2, "product-2", 34.0));
        productList.add(new Product(3, "product-3", 9.0));
    }

    @GetMapping
    public ResponseEntity< ? > getProducts() {
        return ResponseEntity.ok(productList);

    }

    @GetMapping("/{id}")
    public ResponseEntity < ? > getProsucts(@PathVariable int id) {

        Product product = findProduct(id);
        if (product == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid product Id");
        }

        return ResponseEntity.ok(product);

    }

    private Product findProduct(int id) {
        return productList.stream()
                .filter(user -> user.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }

}