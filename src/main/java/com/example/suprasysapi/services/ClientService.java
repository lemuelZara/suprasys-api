package com.example.suprasysapi.services;

import java.util.List;
import java.util.Optional;

import com.example.suprasysapi.domain.Client;
import com.example.suprasysapi.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> findById(Integer id) {
        return repository.findById(id);
    }

    public Page<Client> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Client update(Integer id, Client client) {
        Optional<Client> clientOptional = repository.findById(id);
        
        clientOptional.get().setName(client.getName());
        clientOptional.get().setLogin(client.getLogin());
        clientOptional.get().setPassword(client.getPassword());
        clientOptional.get().setState(client.getState());

        return repository.save(clientOptional.get());
    }
}
