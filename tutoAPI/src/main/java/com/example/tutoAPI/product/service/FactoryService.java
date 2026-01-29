package com.example.tutoAPI.product.service;

import com.example.tutoAPI.product.dto.FactoryRequest;
import com.example.tutoAPI.product.dto.FactoryResponse;
import com.example.tutoAPI.product.dto.ProductResponse;
import com.example.tutoAPI.product.mapper.FactoryMapper;
import com.example.tutoAPI.product.model.Factory;
import com.example.tutoAPI.product.repository.FactoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FactoryService {
   private FactoryRepository factoryRepository;
   private FactoryMapper factoryMapper;


    public FactoryService(FactoryRepository factoryRepository, FactoryMapper factoryMapper) {
         this.factoryRepository = factoryRepository;
         this.factoryMapper = factoryMapper;
    }

    public List<FactoryResponse> getAllFactories() {
        List<Factory> factories = factoryRepository.findAll();
        return factories.stream().map(factoryMapper::toFactoryResponse).toList();
    }

    public FactoryResponse getFactoryById(Long id) {
        Factory factory = factoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Factory not found"));
        return factoryMapper.toFactoryResponse(factory);
    }

    public FactoryResponse saveFactory(FactoryRequest factory) {
        Factory fac = factoryMapper.toFactory(factory);
        Factory savedFactory = factoryRepository.save(fac);
        return factoryMapper.toFactoryResponse(savedFactory);
    }

    public FactoryResponse updateFactory(Long id, FactoryRequest factory) {
        Factory existingfactory = factoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Factory not found"));
        existingfactory.setName(factory.name());
        Factory updatedFactory = factoryRepository.save(existingfactory);
        return factoryMapper.toFactoryResponse(updatedFactory);
    }


    public void deleteFactory(Long id) {
        factoryRepository.deleteById(id);
    }


}
