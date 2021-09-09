package com.example.suprasysapi.modules.clients.usecases.delete_client;

import java.util.Optional;

import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;
import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientUsecase {
    
    @Autowired
    private ClientRepository repository;

    public void execute(Integer id) {
        Optional<Client> client = repository.findById(id);
        
        if (!client.isPresent()) {
            throw new BadRequestException("Unable to delete the client because it doesn't exist!");
        }

        repository.deleteById(id);
    }
}
