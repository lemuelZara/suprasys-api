package com.example.suprasysapi.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SaleDTO {
    @NotBlank
    private LocalDate date;

    @NotBlank
    private double value;

    @NotBlank
    private double discount;

    @NotBlank
    private double total;

    @NotBlank
    private List<SaleProductDTO> itens;
}
