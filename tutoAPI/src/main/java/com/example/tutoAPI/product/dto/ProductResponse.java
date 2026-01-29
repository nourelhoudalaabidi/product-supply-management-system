package com.example.tutoAPI.product.dto;

public record ProductResponse(Long id, String name, double price, Long factoryId, String factoryName, Long categoryId, String categoryName, Long supplierId, String supplierName) {

}

