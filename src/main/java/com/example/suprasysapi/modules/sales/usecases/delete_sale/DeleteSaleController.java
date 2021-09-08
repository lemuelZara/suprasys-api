package com.example.suprasysapi.modules.sales.usecases.delete_sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class DeleteSaleController {

    @Autowired
    private DeleteSaleUsecase deleteSaleUsecase;

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Integer id) {
        deleteSaleUsecase.execute(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
