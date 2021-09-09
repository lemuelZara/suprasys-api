package com.example.suprasysapi.modules.clients.usecases.add_client;

import com.example.suprasysapi.modules.clients.dtos.ClientRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AddClientController {
    
    @Autowired
    private AddClientUsecase addClientUsecase;

    @PostMapping("/clients")
    public ResponseEntity<Object> handle(@RequestBody ClientRequestModel clientRequestModel) {
        Object client = addClientUsecase.execute(clientRequestModel);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
