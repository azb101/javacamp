package com.abuse.calculatorapp.validation;

import com.abuse.calculatorapp.services.CalculationError;

import java.util.List;

public interface InputExpressionValidator {
    List<CalculationError> validate(String input);
}
