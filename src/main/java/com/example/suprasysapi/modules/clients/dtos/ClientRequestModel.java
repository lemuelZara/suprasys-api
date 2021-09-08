package com.example.suprasysapi.modules.clients.dtos;

import lombok.Data;

@Data
public class ClientRequestModel {
    String name;
    String login;
    String password;
    Integer state;
}
