package com.example.suprasysapi.modules.sales.usecases.list_all_sales;

import java.util.List;

import com.example.suprasysapi.modules.sales.entities.Sale;
import com.example.suprasysapi.modules.sales.infra.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListAllSalesUsecase {
    
    @Autowired
    private SaleRepository repository;

    public List<Sale> execute() {
        return repository.findAll();
    }
}
