package com.example.suprasysapi.modules.products.usecases.list_all_products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ListAllProductsController {
    
    @Autowired
    private ListAllProductsUsecase listAllProductsUsecase;

    @GetMapping("/products")
    public ResponseEntity<List<? extends Object>> handle() {
        List<? extends Object> products = listAllProductsUsecase.execute();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
