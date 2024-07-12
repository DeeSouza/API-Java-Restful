package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateProductService {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductModel execute(UUID id, ProductRecordDTO productRecordDTO) throws ProductNotFoundException {
        FindProductByIDService findProductByIDService =  new FindProductByIDService(productRepository);
        final var productModel = findProductByIDService.execute(id);
        BeanUtils.copyProperties(productRecordDTO, productModel);

        return productRepository.save(productModel);
    }
}
