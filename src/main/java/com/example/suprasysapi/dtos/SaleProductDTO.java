package com.example.suprasysapi.dtos;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SaleProductDTO {
    @NotBlank
    private int amount;

    @NotBlank
    private double value;

    @NotBlank
    private double discount;

    @NotBlank
    private double total;

    @NotBlank
    private Map<String, Integer> product;
}
