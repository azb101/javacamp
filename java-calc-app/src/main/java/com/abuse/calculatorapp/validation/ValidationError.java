package com.abuse.calculatorapp.validation;

import com.abuse.calculatorapp.services.CalculationError;

public class ValidationError extends CalculationError {

    public ValidationError(String message) {
        super(message);
    }

    public ValidationError(String message, Exception exception)
    {
        super(message, exception);
    }
}
