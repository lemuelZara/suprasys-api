package com.example.suprasysapi.repositories;

import com.example.suprasysapi.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
