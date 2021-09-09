package com.example.suprasysapi.modules.sales.usecases.add_sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;
import com.example.suprasysapi.modules.products.entities.Product;
import com.example.suprasysapi.modules.products.infra.repositories.ProductRepository;
import com.example.suprasysapi.modules.sales.dtos.SaleRequestModel;
import com.example.suprasysapi.modules.sales.entities.Sale;
import com.example.suprasysapi.modules.sales.entities.SaleProduct;
import com.example.suprasysapi.modules.sales.infra.repositories.SaleRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddSaleUsecase {
    
    @Autowired
    private SaleRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public Sale execute(SaleRequestModel saleRequestModel, Integer clientId) {
        List<SaleProduct> salesProducts = new ArrayList<>();
        Optional<Client> findClient = clientRepository.findById(clientId);

        if (!findClient.isPresent()) {
            throw new BadRequestException("Client does not exists!");
        }

        Sale sale = new Sale();
        sale.setValue(saleRequestModel.getValue());
        sale.setTotal(saleRequestModel.getValue());
        sale.setDate(saleRequestModel.getDate());
        sale.setDiscount(saleRequestModel.getDiscount());
        sale.setClient(findClient.get());

        Stream<SaleProduct> salesProductsStream = saleRequestModel
            .getItens()
            .stream()
            .map(item -> {
                Optional<Product> p = productRepository.findById(item.getProduct().get("id"));

                if (!p.isPresent()) {
                    throw new BadRequestException("Product id(" + item.getProduct().get("id") + ") does not exists!");
                }

                SaleProduct saleProduct = new SaleProduct();
                saleProduct.setValue(item.getValue());
                saleProduct.setAmount(item.getAmount());
                saleProduct.setDiscount(item.getDiscount());
                saleProduct.setTotal(item.getTotal());
                saleProduct.setProduct(p.get());
                saleProduct.setSale(sale);

                return saleProduct;
            });

        salesProducts.addAll(salesProductsStream.collect(Collectors.toList()));

        sale.setItens(salesProducts);

        return repository.save(sale);
    }
}
