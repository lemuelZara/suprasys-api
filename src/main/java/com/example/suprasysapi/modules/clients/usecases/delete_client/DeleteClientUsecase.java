package com.example.suprasysapi.modules.clients.usecases.delete_client;

import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientUsecase {
    
    @Autowired
    private ClientRepository repository;

    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
