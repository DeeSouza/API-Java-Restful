package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.interfaces.IFindProductByIDService;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindProductByIDService implements IFindProductByIDService {
    private final ProductRepository productRepository;
    public FindProductByIDService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel execute(UUID id) throws ProductNotFoundException {
        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }

        return product.get();
    }
}
