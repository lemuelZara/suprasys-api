package com.example.suprasysapi.controllers;

import java.util.Optional;

import com.example.suprasysapi.domain.Sale;
import com.example.suprasysapi.dtos.SaleDTO;
import com.example.suprasysapi.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/sales")
    public ResponseEntity<Page<Sale>> list(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> list(@PathVariable(value = "id") Integer id) {
        Optional<Sale> saleOptional = service.findById(id);

        if (!saleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(saleOptional.get());
        }
    }
}
