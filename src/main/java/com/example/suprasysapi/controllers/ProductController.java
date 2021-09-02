package com.example.suprasysapi.controllers;

import com.example.suprasysapi.domain.Product;
import com.example.suprasysapi.dtos.ProductDTO;
import com.example.suprasysapi.services.ProductService;

import org.springframework.beans.BeanUtils;
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
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);

        service.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
