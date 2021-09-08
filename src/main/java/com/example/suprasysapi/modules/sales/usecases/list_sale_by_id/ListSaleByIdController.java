package com.example.suprasysapi.modules.sales.usecases.list_sale_by_id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ListSaleByIdController {
    
    @Autowired
    private ListSaleByIdUsecase listSaleByIdUsecase;

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> handle(@PathVariable Integer id) {            
        Object sale = listSaleByIdUsecase.execute(id);

        return new ResponseEntity<>(sale, HttpStatus.OK);
    }
}
