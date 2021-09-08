package com.example.suprasysapi.modules.products.usecases.list_all_products;

import java.util.List;

import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListAllProductsUsecase {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> execute() {
        return repository.findAll();
    }
}
