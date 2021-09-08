package com.example.suprasysapi.modules.clients.usecases.list_all_clients;

import java.util.List;

import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListAllClientsUsecase {
    
    @Autowired
    private ClientRepository repository;

    public List<Client> execute() {
        return repository.findAll();
    }
}
