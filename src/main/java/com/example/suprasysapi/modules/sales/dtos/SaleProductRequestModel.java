package com.example.suprasysapi.modules.sales.dtos;

import java.util.Map;

import lombok.Data;

@Data
public class SaleProductRequestModel {
    int amount;
    double value;
    double discount;
    double total;
    Map<String, Integer> product;
}
