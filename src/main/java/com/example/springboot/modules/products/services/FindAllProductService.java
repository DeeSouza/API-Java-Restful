package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;

import java.util.List;
import java.util.UUID;

public class FindAllProductService {
    private final ProductRepository productRepository;
    public FindAllProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductModel> execute() {
        return productRepository.findAll();
    }
}
