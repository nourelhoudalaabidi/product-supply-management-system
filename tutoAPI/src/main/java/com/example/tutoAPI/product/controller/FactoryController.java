package com.example.tutoAPI.product.controller;


import com.example.tutoAPI.product.dto.FactoryRequest;
import com.example.tutoAPI.product.dto.FactoryResponse;
import com.example.tutoAPI.product.service.FactoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factories")
public class FactoryController {
    private FactoryService factoryService;
    public FactoryController(FactoryService factoryService) {

        this.factoryService = factoryService;

    }


    @GetMapping
    public ResponseEntity<List<FactoryResponse>> getFactories() {
        return ResponseEntity.ok(factoryService.getAllFactories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactoryResponse> getFactoriesById(@PathVariable Long id) {
        return ResponseEntity.ok(factoryService.getFactoryById(id));
    }

    @PostMapping
    public ResponseEntity<FactoryResponse> createFactory(@Valid @RequestBody FactoryRequest factory) {
        return ResponseEntity.ok(factoryService.saveFactory(factory));

    }

   @PutMapping("/{id}")
    public ResponseEntity<FactoryResponse>  updateFactory(@PathVariable Long id, @RequestBody FactoryRequest factory) {
        return ResponseEntity.ok(factoryService.updateFactory(id, factory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactory(@PathVariable Long id) {
         factoryService.deleteFactory(id);
         return ResponseEntity.noContent().build();
    }


}


