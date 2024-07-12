package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;

import java.util.Optional;
import java.util.UUID;

public class DeleteProductService {
    private final ProductRepository productRepository;
    public DeleteProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void execute(UUID id) throws ProductNotFoundException {
        FindProductByIDService findProductByIDService =  new FindProductByIDService(productRepository);
        final var product = findProductByIDService.execute(id);

        productRepository.delete(product);
    }
}
