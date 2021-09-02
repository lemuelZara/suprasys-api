package com.example.suprasysapi.services;

import com.example.suprasysapi.domain.Product;
import com.example.suprasysapi.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }
}
