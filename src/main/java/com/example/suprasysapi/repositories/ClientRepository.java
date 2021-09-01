package com.example.suprasysapi.repositories;

import com.example.suprasysapi.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
