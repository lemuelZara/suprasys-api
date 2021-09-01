package com.example.suprasysapi.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ClientDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private Integer state;
}
