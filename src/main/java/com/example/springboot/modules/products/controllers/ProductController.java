package com.example.springboot.modules.products.controllers;

import com.example.springboot.modules.products.interfaces.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springboot.modules.products.dtos.ProductRecordDTO;
import com.example.springboot.modules.products.models.ProductModel;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IAddProductService addProductService;

    @Autowired
    IFindAllProductService findAllProductService;

    @Autowired
    IDeleteProductService deleteProductService;

    @Autowired
    IFindProductByIDService findProductByIdService;

    @Autowired
    IUpdateProductService updateProductService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(findAllProductService.execute());
    }

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO) {
        final var productAdded = addProductService.execute(productRecordDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(findProductByIdService.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ProductRecordDTO productRecordDTO) {
        final var productUpdated = updateProductService.execute(id, productRecordDTO);

        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
        deleteProductService.execute(id);

        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }
}
