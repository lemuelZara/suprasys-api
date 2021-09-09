package com.example.suprasysapi.shared.errors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.suprasysapi.shared.exceptions.BadRequestException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralErrorHandling extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, HttpServletRequest req, HttpServletResponse response) {
        ErrorInfo error = new ErrorInfo(ex, 500);

        if (ex instanceof BadRequestException) {
            return badRequestException(ex);
        }

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestException(Exception ex) {
        ErrorInfo error = new ErrorInfo(ex, 400);
    
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
