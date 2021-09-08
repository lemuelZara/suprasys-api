package com.example.suprasysapi.modules.sales.usecases.delete_sale;

import com.example.suprasysapi.modules.sales.entities.Sale;
import com.example.suprasysapi.modules.sales.infra.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSaleUsecase {
    
    @Autowired
    private SaleRepository repository;

    public void execute(Integer id) {
        Sale sale = repository.findById(id).get();

        sale.getItens().removeAll(sale.getItens());

        repository.delete(sale);
    }
}
