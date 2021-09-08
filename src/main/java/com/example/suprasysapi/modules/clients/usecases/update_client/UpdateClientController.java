package com.example.suprasysapi.modules.clients.usecases.update_client;

import com.example.suprasysapi.modules.clients.dtos.ClientRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UpdateClientController {
    
    @Autowired
    private UpdateClientUsecase updateClientUsecase;

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Integer id, @RequestBody ClientRequestModel clientRequestModel) {
        Object client = updateClientUsecase.execute(id, clientRequestModel);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
