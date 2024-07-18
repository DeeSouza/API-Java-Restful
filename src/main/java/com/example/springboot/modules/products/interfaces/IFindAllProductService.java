package com.example.springboot.modules.products.interfaces;

import com.example.springboot.modules.products.models.ProductModel;
import java.util.List;

public interface IFindAllProductService {
    List<ProductModel> execute();
}
