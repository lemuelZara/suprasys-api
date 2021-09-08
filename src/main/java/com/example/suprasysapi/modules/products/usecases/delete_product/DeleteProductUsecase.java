package com.example.suprasysapi.modules.products.usecases.delete_product;

import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUsecase {
    
    @Autowired
    private ProductRepository repository;

    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
