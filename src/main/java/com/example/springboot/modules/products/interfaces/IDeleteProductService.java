package com.example.springboot.modules.products.interfaces;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import java.util.UUID;

public interface IDeleteProductService {
    public void execute(UUID id) throws ProductNotFoundException;
}
