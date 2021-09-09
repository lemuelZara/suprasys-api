package com.example.suprasysapi.shared.exceptions;

import org.springframework.stereotype.Component;

@Component
public class BadRequestException extends RuntimeException {
    
    public BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }
}
