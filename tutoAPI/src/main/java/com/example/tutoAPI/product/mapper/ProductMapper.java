package com.example.tutoAPI.product.mapper;

import com.example.tutoAPI.product.dto.ProductRequest;
import com.example.tutoAPI.product.dto.ProductResponse;
import com.example.tutoAPI.product.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        return product;
    }
    public ProductResponse toProductResponse(Product product){

        ProductResponse prodRes = new ProductResponse(
                product.getId(),product.getName(),product.getPrice(),
                product.getFactory().getId(), product.getFactory().getName(),
                product.getCategory().getId(),product.getCategory().getName(),
                product.getSupplier().getId(), product.getSupplier().getName());

        return prodRes;
    }

}
