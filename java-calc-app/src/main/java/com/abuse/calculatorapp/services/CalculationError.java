package com.abuse.calculatorapp.services;

public abstract class CalculationError {
    private final String message;
    private Exception exception;


    public CalculationError(String message) {
        this.message = message;
    }

    public CalculationError(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
