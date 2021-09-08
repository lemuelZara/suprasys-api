package com.example.suprasysapi.modules.products.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.suprasysapi.modules.sales.entities.SaleProduct;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "discount", nullable = false)
    private double discount;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<SaleProduct> itens;
}
