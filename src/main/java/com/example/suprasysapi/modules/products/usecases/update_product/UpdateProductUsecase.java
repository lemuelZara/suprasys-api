package com.example.suprasysapi.modules.products.usecases.update_product;

import java.util.Optional;

import com.example.suprasysapi.modules.products.dtos.ProductRequestModel;
import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUsecase {
    
    @Autowired
    private ProductRepository repository;

    public Product execute(Integer id, ProductRequestModel productRequestModel) {
        Optional<Product> productOptional = repository.findById(id);

        productOptional.get().setName(productRequestModel.getName());
        productOptional.get().setStock(productRequestModel.getStock());
        productOptional.get().setValue(productRequestModel.getValue());
        productOptional.get().setDiscount(productRequestModel.getDiscount());

        return repository.save(productOptional.get());
    }
}
