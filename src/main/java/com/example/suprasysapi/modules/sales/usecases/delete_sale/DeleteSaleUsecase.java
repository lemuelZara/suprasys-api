package com.example.suprasysapi.modules.sales.usecases.delete_sale;

import java.util.Optional;

import com.example.suprasysapi.modules.sales.entities.Sale;
import com.example.suprasysapi.modules.sales.infra.repositories.SaleRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSaleUsecase {
    
    @Autowired
    private SaleRepository repository;

    public void execute(Integer id) {
        Optional<Sale> sale = repository.findById(id);

        if (!sale.isPresent()) {
            throw new BadRequestException("Unable to delete the sale because it doesn't exist!");
        }

        sale.get().getItens().removeAll(sale.get().getItens());

        repository.delete(sale.get());
    }
}
