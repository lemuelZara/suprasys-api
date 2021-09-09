package com.example.suprasysapi.modules.sales.usecases.add_sale;

import com.example.suprasysapi.modules.sales.dtos.SaleRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AddSaleController {
    
    @Autowired
    private AddSaleUsecase addSaleUsecase;

    @PostMapping("/sales")
    public ResponseEntity<Object> handle(@RequestBody SaleRequestModel saleRequestModel, @RequestHeader String clientId) {
        Object sale = addSaleUsecase.execute(saleRequestModel, Integer.parseInt(clientId));

        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }
}
