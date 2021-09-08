package com.example.suprasysapi.modules.sales.infra.repositories;

import com.example.suprasysapi.modules.sales.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> { }
