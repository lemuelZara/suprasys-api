package com.example.suprasysapi.modules.products.usecases.add_product;

import java.util.Optional;

import com.example.suprasysapi.modules.products.dtos.ProductRequestModel;
import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductUsecase {
    
    @Autowired
    private ProductRepository repository;

    public Product execute(ProductRequestModel productRequestModel) {
        Optional<Product> productAlreadyExists = repository.findByName(productRequestModel.getName());

        if (productAlreadyExists.isPresent()) {
            throw new BadRequestException("This product already exists. Try again!");
        }

        Product product = new Product();
        product.setName(productRequestModel.getName());
        product.setStock(productRequestModel.getStock());
        product.setValue(productRequestModel.getValue());
        product.setDiscount(productRequestModel.getDiscount());

        return repository.save(product);
    }
}
