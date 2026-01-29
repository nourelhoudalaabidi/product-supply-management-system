package com.example.tutoAPI.product.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SupplierRequest(
              @NotBlank(message = "Name is mandatory" )
               String name,

                @Email(message = "Email should be valid")
                @NotBlank(message = "Email is mandatory")
                String email
) {


}
