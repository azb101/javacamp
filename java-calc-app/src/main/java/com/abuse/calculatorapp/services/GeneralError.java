package com.abuse.calculatorapp.services;

public class GeneralError extends CalculationError {
    public GeneralError(String message) {
        super(message);
    }

    public GeneralError(String message, Exception exception) {
        super(message, exception);
    }
}
