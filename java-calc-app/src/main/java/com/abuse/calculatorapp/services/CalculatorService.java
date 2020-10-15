package com.abuse.calculatorapp.services;

/**
 * Service will be able to solve complex equations with () +-/*
 */
public interface CalculatorService {
    CalculationResult solve(String equation);
}
