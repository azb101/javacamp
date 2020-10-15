package com.abuse.calculatorapp.services.exceptions;

public class DivisionByZeroException extends ArithmeticException {

    public DivisionByZeroException()
    {

    }

    public DivisionByZeroException(String expression) {
        super(expression);
    }
}
