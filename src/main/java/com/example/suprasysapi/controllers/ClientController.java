package com.example.suprasysapi.controllers;

import com.example.suprasysapi.domain.Client;
import com.example.suprasysapi.dtos.ClientDTO;
import com.example.suprasysapi.services.ClientService;

import org.springframework.beans.BeanUtils;
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
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping("/clients")
    public ResponseEntity<Client> create(@RequestBody ClientDTO clientDTO) throws Exception {
        Client client = new Client();

        BeanUtils.copyProperties(clientDTO, client);

        service.create(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
