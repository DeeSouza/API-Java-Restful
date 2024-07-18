package com.example.springboot.modules.products.interfaces;

import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.models.ProductModel;

public interface IAddProductService {
    public ProductModel execute(ProductRecordDTO productRecordDTO);
}
