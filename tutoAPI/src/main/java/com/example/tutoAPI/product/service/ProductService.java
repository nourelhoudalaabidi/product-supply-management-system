package com.example.tutoAPI.product.service;


import com.example.tutoAPI.product.dto.ProductRequest;
import com.example.tutoAPI.product.dto.ProductResponse;
import com.example.tutoAPI.product.exceptions.CategoryException;
import com.example.tutoAPI.product.exceptions.FactoryException;
import com.example.tutoAPI.product.exceptions.ProductException;
import com.example.tutoAPI.product.mapper.ProductMapper;
import com.example.tutoAPI.product.model.Category;
import com.example.tutoAPI.product.model.Factory;
import com.example.tutoAPI.product.model.Product;
import com.example.tutoAPI.product.model.Supplier;
import com.example.tutoAPI.product.repository.CategoryRepository;
import com.example.tutoAPI.product.repository.FactoryRepository;
import com.example.tutoAPI.product.repository.ProductRepository;
import com.example.tutoAPI.product.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private final SupplierRepository supplierRepository;
    private  FactoryRepository factoryRepository;
    private CategoryRepository categoryRepository;
    private  ProductRepository productRepository;
    private ProductMapper productMapper;

    ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper,
            FactoryRepository factoryRepository,
            CategoryRepository categoryRepository,
            SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.factoryRepository = factoryRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<ProductResponse> getAllProducts() {
         List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductResponse).toList();

    }


    public ProductResponse getProductById(Long id) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Product not found"));

        return productMapper.toProductResponse(productById);
    }



    public ProductResponse saveProduct(ProductRequest product) {
        Factory factory = factoryRepository.findById(product.factoryId()).orElseThrow(() -> new FactoryException("Factory not found"));
        Category category = categoryRepository.findById(product.categoryId()).orElseThrow(() -> new CategoryException("Category not found"));
        Supplier supplier = supplierRepository.findById(product.supplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        Product prod = productMapper.toProduct(product);
        prod.setFactory(factory);
        prod.setCategory(category);
        prod.setSupplier(supplier);
        Product savedProduct = productRepository.save(prod);
        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse updateProduct(ProductRequest product, Long id) {

        Product existingProduct = productRepository.findById(id).orElseThrow(()->new ProductException("Product not found"));
        existingProduct.setName(product.name());
        existingProduct.setPrice(product.price());
        Product updatedProduct = productRepository.save(existingProduct);
        return  productMapper.toProductResponse(updatedProduct);
    }

    public Product getProductByNameAndPrice(String name, double price) {
        return productRepository.findByNameAndPrice(name, price).orElseThrow(()->new ProductException("Product not found"));
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
