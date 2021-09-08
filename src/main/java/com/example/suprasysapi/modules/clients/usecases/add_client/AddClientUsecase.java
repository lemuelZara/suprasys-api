package com.example.suprasysapi.modules.clients.usecases.add_client;

import java.util.Optional;

import com.example.suprasysapi.modules.clients.dtos.ClientRequestModel;
import com.example.suprasysapi.modules.clients.entities.Client;
import com.example.suprasysapi.modules.clients.infra.repositories.ClientRepository;
import com.example.suprasysapi.shared.providers.hash_provider.HashProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddClientUsecase {
    
    @Autowired
    private ClientRepository repository;

    @Autowired
    private HashProvider hashProvider;

    public Client execute(ClientRequestModel clientRequestModel) throws Exception {
        Optional<Client> clientAlreadyExists = repository.findByLogin(clientRequestModel.getLogin());

        if (clientAlreadyExists.isPresent()) {
            throw new Exception("This login already exists. Try again!");
        }

        Client client = new Client();
        client.setName(clientRequestModel.getName());
        client.setLogin(clientRequestModel.getLogin());

        String hashedPassword = hashProvider.generateHash().encode(
            clientRequestModel.getPassword()
        );    
        client.setPassword(hashedPassword);
        client.setState(clientRequestModel.getState());

        return repository.save(client);
    }
}
