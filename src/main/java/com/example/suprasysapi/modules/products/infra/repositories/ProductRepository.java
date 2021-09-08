package com.example.suprasysapi.modules.products.infra.repositories;

import java.util.Optional;

import com.example.suprasysapi.modules.products.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { 
    Optional<Product> findByName(String name);
}
