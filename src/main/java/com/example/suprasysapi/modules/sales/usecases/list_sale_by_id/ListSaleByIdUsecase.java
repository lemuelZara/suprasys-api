package com.example.suprasysapi.modules.sales.usecases.list_sale_by_id;

import java.util.Optional;

import com.example.suprasysapi.modules.sales.entities.Sale;
import com.example.suprasysapi.modules.sales.infra.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListSaleByIdUsecase {
    
    @Autowired
    private SaleRepository repository;

    public Sale execute(Integer id) {
        Optional<Sale> sale = repository.findById(id);

        return sale.get();
    }
}
