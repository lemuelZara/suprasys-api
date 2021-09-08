package com.example.suprasysapi.modules.products.dtos;

import lombok.Data;

@Data
public class ProductRequestModel {
    String name;
    Integer stock;
    double value;
    double discount;
}

