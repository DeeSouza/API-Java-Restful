package com.example.springboot.modules.products.interfaces;

import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.models.ProductModel;

import java.util.UUID;

public interface IUpdateProductService
{
    public ProductModel execute(UUID id, ProductRecordDTO productRecordDTO) throws ProductNotFoundException;
}
