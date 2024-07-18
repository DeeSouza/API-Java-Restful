package com.example.springboot.modules.products.interfaces;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.models.ProductModel;

import java.util.UUID;

public interface IFindProductByIDService {
    public ProductModel execute(UUID id) throws ProductNotFoundException;
}
