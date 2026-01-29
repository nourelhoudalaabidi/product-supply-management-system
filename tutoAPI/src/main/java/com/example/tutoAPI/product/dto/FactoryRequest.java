package com.example.tutoAPI.product.dto;


import jakarta.validation.constraints.NotBlank;

public record FactoryRequest(
        @NotBlank(message = "Name is mandatory")
        String name
) {

}
