package com.example.suprasysapi.modules.products.usecases.update_product;

import com.example.suprasysapi.modules.products.dtos.ProductRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UpdateProductController {
    
    @Autowired
    private UpdateProductUsecase updateProductUsecase;

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Integer id, @RequestBody ProductRequestModel productRequestModel) {
        Object product = updateProductUsecase.execute(id, productRequestModel);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
