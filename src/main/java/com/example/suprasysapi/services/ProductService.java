package com.example.suprasysapi.services;

import java.util.Optional;

import com.example.suprasysapi.domain.Product;
import com.example.suprasysapi.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
