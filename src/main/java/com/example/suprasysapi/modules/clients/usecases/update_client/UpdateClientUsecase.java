package com.example.suprasysapi.modules.clients.usecases.update_client;

import java.util.Optional;

import com.example.suprasysapi.modules.clients.dtos.ClientRequestModel;
import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;
import com.example.suprasysapi.shared.providers.hash_provider.HashProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUsecase {
    
    @Autowired
    private ClientRepository repository;

    @Autowired
    private HashProvider hashProvider;

    public Client execute(Integer id, ClientRequestModel clientRequestModel) {
        Optional<Client> clientOptional = repository.findById(id);

        clientOptional.get().setName(clientRequestModel.getName());
        clientOptional.get().setLogin(clientRequestModel.getLogin());       

        String hashedPassword = hashProvider.generateHash().encode(
            clientRequestModel.getPassword()
        );
        clientOptional.get().setPassword(hashedPassword);
        clientOptional.get().setState(clientRequestModel.getState());

        return repository.save(clientOptional.get());
    }
}
