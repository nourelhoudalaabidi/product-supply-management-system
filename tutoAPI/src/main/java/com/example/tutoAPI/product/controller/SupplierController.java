package com.example.tutoAPI.product.controller;


import com.example.tutoAPI.product.dto.FactoryResponse;
import com.example.tutoAPI.product.dto.SupplierRequest;
import com.example.tutoAPI.product.dto.SupplierResponse;
import com.example.tutoAPI.product.model.Supplier;
import com.example.tutoAPI.product.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {


        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAllSuppliers() {

        return    ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<SupplierResponse> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PostMapping
        public ResponseEntity<SupplierResponse>  addSupplier(@RequestBody SupplierRequest  supplier) {
        return ResponseEntity.ok(supplierService.createSupplier(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse>  updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest supplier) {
        return  ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }


}
