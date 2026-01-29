package com.example.tutoAPI.product.service;


import com.example.tutoAPI.product.dto.SupplierRequest;
import com.example.tutoAPI.product.dto.SupplierResponse;
import com.example.tutoAPI.product.mapper.SupplierMapper;

import com.example.tutoAPI.product.model.Supplier;
import com.example.tutoAPI.product.repository.SupplierRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class SupplierService {

    private SupplierRepository supplierRepository;
    private SupplierMapper supplierMapper;

    private  SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {

        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;

    }

    public List<SupplierResponse> getAllSuppliers() {
        List <Supplier> suppliers =  supplierRepository.findAll();
        return suppliers.stream().map(supplierMapper::toSupplierResponse).toList();
    }

    public SupplierResponse getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        return supplierMapper.toSupplierResponse(supplier);
    }
    public SupplierResponse createSupplier( SupplierRequest supplier) {
        Supplier sup = supplierMapper.toSupplier(supplier);
        Supplier savedSupplier = supplierRepository.save(sup);
        return supplierMapper.toSupplierResponse(savedSupplier);
    }

    public SupplierResponse updateSupplier(Long id, SupplierRequest supplier) {
        Supplier existingSupplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));

        if (supplier.name() != null && !supplier.name().isBlank()) {
            existingSupplier.setName(supplier.name());
        }

        if (StringUtils.hasText(supplier.email())) {
            existingSupplier.setEmail(supplier.email());
        }


        try {
            Supplier updatedSupplier = supplierRepository.save(existingSupplier);
            return supplierMapper.toSupplierResponse(updatedSupplier);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Failed to update supplier: data integrity violation - " + ex.getMostSpecificCause().getMessage(), ex);
        }
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
