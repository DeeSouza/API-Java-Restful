package com.example.springboot.modules.products.services;

import com.example.springboot.modules.products.interfaces.IAddProductService;
import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AddProductService implements IAddProductService {
    private final ProductRepository productRepository;

    public AddProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel execute(ProductRecordDTO productRecordDTO) {
        final var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productModel);

        return productRepository.save(productModel);
    }
}
