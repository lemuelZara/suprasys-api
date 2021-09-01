package com.example.suprasysapi.controllers;

import java.util.List;
import java.util.Optional;

import com.example.suprasysapi.domain.Client;
import com.example.suprasysapi.dtos.ClientDTO;
import com.example.suprasysapi.services.ClientService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        service.save(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<Page<Client>> list(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> show(@PathVariable(value = "id") Integer id) {
        Optional<Client> clientOptional = service.findById(id);

        if (!clientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());
        }
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody ClientDTO clientDTO) {
        Client client = new Client();

        BeanUtils.copyProperties(clientDTO, client);

        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, client));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
