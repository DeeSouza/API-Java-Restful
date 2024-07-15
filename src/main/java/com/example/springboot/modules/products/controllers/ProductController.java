package com.example.springboot.modules.products.controllers;

import com.example.springboot.modules.products.exceptions.ProductNotFoundException;
import com.example.springboot.modules.products.services.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.models.ProductModel;
import com.example.springboot.modules.products.repositories.ProductRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        final FindAllProductService productList = new FindAllProductService(productRepository);

        return ResponseEntity.status(HttpStatus.OK).body(productList.execute());
    }

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO) {
        final AddProductService addProductService = new AddProductService(productRepository);
        final var productAdded = addProductService.execute(productRecordDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
        final FindProductByIDService product = new FindProductByIDService(productRepository);
        return ResponseEntity.status(HttpStatus.OK).body(product.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ProductRecordDTO productRecordDTO) {
        final UpdateProductService updateProductService = new UpdateProductService(productRepository);
        final var productUpdated = updateProductService.execute(id, productRecordDTO);

        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
        final DeleteProductService deleteProductService = new DeleteProductService(productRepository);
        deleteProductService.execute(id);

        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }
}
