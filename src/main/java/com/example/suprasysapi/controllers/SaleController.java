package com.example.suprasysapi.controllers;

import com.example.suprasysapi.domain.Sale;
import com.example.suprasysapi.dtos.SaleDTO;
import com.example.suprasysapi.services.SaleService;

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
public class SaleController {
    @Autowired
    private SaleService service;

    @PostMapping("/sales")
    public ResponseEntity<Sale> create(@RequestBody SaleDTO saleDTO, @RequestHeader String clientId) {
        Sale sale = service.save(saleDTO, Integer.parseInt(clientId));

        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }
}
