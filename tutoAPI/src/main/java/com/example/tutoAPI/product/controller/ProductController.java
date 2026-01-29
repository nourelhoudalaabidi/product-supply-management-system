package com.example.tutoAPI.product.controller;


import com.example.tutoAPI.product.dto.ProductRequest;
import com.example.tutoAPI.product.dto.ProductResponse;
import com.example.tutoAPI.product.model.Product;
import com.example.tutoAPI.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
 private  ProductService productService;
   public ProductController(ProductService productService) {
        this.productService = productService;
    }
        @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id)) ;

    }


    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody  ProductRequest product) {

        return ResponseEntity.ok(productService.saveProduct(product));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest product) {

        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    @GetMapping("/{name}/{price}")
    public Product getProductByNameAndPrice(@PathVariable String name, @PathVariable double price) {
        return productService.getProductByNameAndPrice(name, price);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
      return ResponseEntity.noContent().build();
    }
}
