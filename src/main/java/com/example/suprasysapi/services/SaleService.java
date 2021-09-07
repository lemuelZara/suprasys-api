package com.example.suprasysapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.suprasysapi.domain.Client;
import com.example.suprasysapi.domain.Product;
import com.example.suprasysapi.domain.Sale;
import com.example.suprasysapi.domain.SaleProduct;
import com.example.suprasysapi.dtos.SaleDTO;
import com.example.suprasysapi.repositories.ClientRepository;
import com.example.suprasysapi.repositories.ProductRepository;
import com.example.suprasysapi.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public Sale save(SaleDTO saleDTO, Integer clientId) {
        List<SaleProduct> salesProducts = new ArrayList<>();
        Optional<Client> findClient = clientRepository.findById(clientId);

        Sale sale = new Sale();
        sale.setValue(saleDTO.getValue());
        sale.setTotal(saleDTO.getValue());
        sale.setDate(saleDTO.getDate());
        sale.setDiscount(saleDTO.getDiscount());
        sale.setClient(findClient.get());

        Stream<SaleProduct> s = saleDTO
            .getItens()
            .stream()
            .map(item -> {
                Optional<Product> p = productRepository.findById(item.getProduct().get("id"));

                SaleProduct saleProduct = new SaleProduct();
                saleProduct.setValue(item.getValue());
                saleProduct.setAmount(item.getAmount());
                saleProduct.setDiscount(item.getDiscount());
                saleProduct.setTotal(item.getTotal());
                saleProduct.setProduct(p.get());
                saleProduct.setSale(sale);

                return saleProduct;
            });
        
        salesProducts.addAll(s.collect(Collectors.toList()));
        
        sale.setItens(salesProducts);

        return saleRepository.save(sale);
    }

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public Optional<Sale> findById(Integer id) {
        return saleRepository.findById(id);
    }
}
