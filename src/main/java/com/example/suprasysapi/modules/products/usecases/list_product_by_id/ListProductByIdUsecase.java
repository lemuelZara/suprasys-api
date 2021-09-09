package com.example.suprasysapi.modules.products.usecases.list_product_by_id;

import java.util.Optional;

import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListProductByIdUsecase {
    
    @Autowired
    private ProductRepository repository;

    public Product execute(Integer id) {
        Optional<Product> product = repository.findById(id);

        if (!product.isPresent()) {
            throw new BadRequestException("Product not exists!");
        }

        return product.get();
    }
}
