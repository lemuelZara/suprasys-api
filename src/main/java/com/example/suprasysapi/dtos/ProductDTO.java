package com.example.suprasysapi.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank
    private String name;

    @NotBlank
    private int stock;

    @NotBlank
    private double value;

    @NotBlank
    private double discount;
}
