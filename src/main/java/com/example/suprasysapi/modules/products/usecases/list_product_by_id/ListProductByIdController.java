package com.example.suprasysapi.modules.products.usecases.list_product_by_id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ListProductByIdController {
    
    @Autowired
    private ListProductByIdUsecase listProductByIdUsecase;

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> handle(@PathVariable Integer id) {            
        Object product = listProductByIdUsecase.execute(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
