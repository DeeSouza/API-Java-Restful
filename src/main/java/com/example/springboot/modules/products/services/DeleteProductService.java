package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.interfaces.IDeleteProductService;
import com.example.springboot.modules.products.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductService implements IDeleteProductService {
    private final ProductRepository productRepository;
    public DeleteProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void execute(UUID id) throws ProductNotFoundException {
        FindProductByIDService findProductByIDService =  new FindProductByIDService(productRepository);
        final var product = findProductByIDService.execute(id);

        productRepository.delete(product);
    }
}
