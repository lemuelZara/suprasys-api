package com.example.suprasysapi.modules.clients.usecases.list_client_by_id;

import java.util.Optional;

import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ListClientByIdUsecase {
    
    @Autowired
    private ClientRepository repository;

    public Client execute(Integer id) {
        Optional<Client> client = repository.findById(id);

        if (!client.isPresent()) {
            throw new BadRequestException("Client not exists!");
        }

        return client.get();
    }
}
