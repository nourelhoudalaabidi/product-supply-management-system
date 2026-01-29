package com.example.tutoAPI.product.mapper;


import com.example.tutoAPI.product.dto.SupplierRequest;
import com.example.tutoAPI.product.dto.SupplierResponse;
import com.example.tutoAPI.product.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public Supplier toSupplier(SupplierRequest supplierRequest) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierRequest.name());
        supplier.setEmail((supplierRequest.email()));
        return supplier;
}

public SupplierResponse toSupplierResponse(Supplier supplier) {
    SupplierResponse supplierRes = new SupplierResponse(
            supplier.getId(), supplier.getName(), supplier.getEmail());
    return supplierRes;
}


}