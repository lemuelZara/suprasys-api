package com.example.suprasysapi.shared.errors;

import java.time.ZonedDateTime;

public class ErrorInfo {
    public final ZonedDateTime timestamp;
    public final String error;
    public final String message;
    public final Integer status;

    public ErrorInfo(Exception ex, Integer status) {
        this.timestamp = ZonedDateTime.now();
        this.error = ex.getClass().getSimpleName();
        this.message = status == 500 ? "Something went wrong! Try again later." : ex.getLocalizedMessage();
        this.status = status;
    }
}
