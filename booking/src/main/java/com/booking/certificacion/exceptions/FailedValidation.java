package com.booking.certificacion.exceptions;

public class FailedValidation extends AssertionError {

    public FailedValidation(String message, Throwable cause) {
        super(message, cause);
    }
}
