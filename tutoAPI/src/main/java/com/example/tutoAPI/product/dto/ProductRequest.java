package com.example.tutoAPI.product.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record  ProductRequest(

        @NotBlank(message = "Name is mandatory")
        String name,
        @Min(1)
        @Max(4)
        double price,
        Long factoryId,
        Long categoryId,
        Long supplierId
){



}
