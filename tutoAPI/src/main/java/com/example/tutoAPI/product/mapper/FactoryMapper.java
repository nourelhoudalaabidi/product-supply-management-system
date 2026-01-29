package com.example.tutoAPI.product.mapper;


import com.example.tutoAPI.product.dto.FactoryRequest;
import com.example.tutoAPI.product.dto.FactoryResponse;
import com.example.tutoAPI.product.model.Factory;
import org.springframework.stereotype.Component;

@Component
public class FactoryMapper {


    public Factory toFactory(FactoryRequest factoryRequest) {
        Factory factory = new Factory();
        factory.setName(factoryRequest.name());
        return factory;
    }
    public FactoryResponse toFactoryResponse(Factory factory) {
        FactoryResponse factoryRes = new FactoryResponse(factory.getId(), factory.getName());
        return factoryRes;
    }

}
