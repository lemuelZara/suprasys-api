package com.example.suprasysapi.modules.products.usecases.add_product;

import com.example.suprasysapi.modules.products.dtos.ProductRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AddProductController {
    
    @Autowired
    private AddProductUsecase addProductUsecase;

    @PostMapping("/products")
    public ResponseEntity<Object> handle(@RequestBody ProductRequestModel productRequestModel) {
        Object product = addProductUsecase.execute(productRequestModel);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
