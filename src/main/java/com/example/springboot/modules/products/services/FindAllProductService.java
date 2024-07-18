package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.interfaces.IFindAllProductService;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductService implements IFindAllProductService {
    private final ProductRepository productRepository;

    @Autowired
    public FindAllProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> execute() {
        return productRepository.findAll();
    }
}
