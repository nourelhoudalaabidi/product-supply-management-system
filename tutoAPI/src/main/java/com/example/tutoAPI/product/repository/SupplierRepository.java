package com.example.tutoAPI.product.repository;

import com.example.tutoAPI.product.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository  extends JpaRepository<Supplier, Long> {
}
