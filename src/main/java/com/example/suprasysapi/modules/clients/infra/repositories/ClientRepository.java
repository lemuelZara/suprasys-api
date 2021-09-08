package com.example.suprasysapi.modules.clients.infra.repositories;

import java.util.Optional;

import com.example.suprasysapi.modules.clients.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> { 
    Optional<Client> findByLogin(String login);
}
