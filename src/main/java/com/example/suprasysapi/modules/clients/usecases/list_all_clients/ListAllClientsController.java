package com.example.suprasysapi.modules.clients.usecases.list_all_clients;

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
public class ListAllClientsController {
    
    @Autowired
    private ListAllClientsUsecase listAllClientsUsecase;

    @GetMapping("/clients")
    public ResponseEntity<List<? extends Object>> handle() {
        List<? extends Object> clients = listAllClientsUsecase.execute();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
