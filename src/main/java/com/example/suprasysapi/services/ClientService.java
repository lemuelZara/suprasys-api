package com.example.suprasysapi.services;

import com.example.suprasysapi.domain.Client;
import com.example.suprasysapi.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Client create(Client client) {
        return repository.save(client);
    }
}
