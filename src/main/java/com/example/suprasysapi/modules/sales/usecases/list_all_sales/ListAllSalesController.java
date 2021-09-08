package com.example.suprasysapi.modules.sales.usecases.list_all_sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ListAllSalesController {
    
    @Autowired
    private ListAllSalesUsecase listAllSalesUsecase;

    @GetMapping("/sales")
    public ResponseEntity<List<? extends Object>> handle() {
        List<? extends Object> sales = listAllSalesUsecase.execute();

        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
}
