package com.example.suprasysapi.modules.products.usecases.delete_product;

import java.util.Optional;

import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUsecase {
    
    @Autowired
    private ProductRepository repository;

    public void execute(Integer id) {
        Optional<Product> product = repository.findById(id);
        
        if (!product.isPresent()) {
            throw new BadRequestException("Unable to delete the product because it doesn't exist!");
        }

        repository.deleteById(id);
    }
}
