package com.example.suprasysapi.repositories;

import javax.transaction.Transactional;

import com.example.suprasysapi.domain.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>, CrudRepository<Sale, Integer> { }
