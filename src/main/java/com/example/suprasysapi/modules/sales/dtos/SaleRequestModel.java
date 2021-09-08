package com.example.suprasysapi.modules.sales.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SaleRequestModel {
    LocalDate date;
    double value;
    double discount;
    double total;
    List<SaleProductRequestModel> itens;
}
