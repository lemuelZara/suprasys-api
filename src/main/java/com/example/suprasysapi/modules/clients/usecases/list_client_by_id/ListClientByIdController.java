package com.example.suprasysapi.modules.clients.usecases.list_client_by_id;

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
public class ListClientByIdController {
    
    @Autowired
    private ListClientByIdUsecase listClientByIdUsecase;

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> handle(@PathVariable Integer id) {            
        Object client = listClientByIdUsecase.execute(id);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
