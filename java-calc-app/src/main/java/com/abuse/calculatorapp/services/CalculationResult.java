package com.abuse.calculatorapp.services;

import com.abuse.calculatorapp.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;

public class CalculationResult {
    private final String INVALID_RESULT_MESSAGE = "Result couldn't be evaluated";
    private final String VALID_RESULT_MESSAGE = "Result has been evaluated";

    private double value = 0.0;
    private List<CalculationError> errors = new ArrayList<>();

    public CalculationResultType getType() {
        return errors.size() == 0
                ? CalculationResultType.VALID
                : CalculationResultType.INVALID;
    }

    public double getValue() {
        return value;
    }

    public List<CalculationError> getErrors() {
        return errors;
    }

    public void setValue(double result) {
        this.value = result;
    }

    public void setErrors(List<CalculationError> errors) {
        this.errors = errors;
    }

    public void addError(CalculationError error) {
        this.errors.add(error);
    }

    public void print() {
        if(getType() == CalculationResultType.INVALID)
        {
            System.out.println(String.format("%1$s:", INVALID_RESULT_MESSAGE));

            for(var error : errors)
            {
                System.out.println(String.format("  %1$s", error.getMessage()));
            }
        }
        else
        {
            System.out.println(String.format("%1$s: %2$s",VALID_RESULT_MESSAGE, value));
        }
    }
}
