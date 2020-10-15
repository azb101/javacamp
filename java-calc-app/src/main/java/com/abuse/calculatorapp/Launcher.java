package com.abuse.calculatorapp;

import com.abuse.calculatorapp.calculators.Calculator;
import com.abuse.calculatorapp.services.CalculatorServiceImpl;
import com.abuse.calculatorapp.validation.InputExpressionValidatorImpl;
import org.picocontainer.*;

class Launcher {
    private static MutablePicoContainer container;

    public static void main(String[] args) {
        InitializeAndConfigure();

        Calculator calculator = container.getComponent(Calculator.class);
        calculator.run();
    }

    private static void InitializeAndConfigure() {
        container = new DefaultPicoContainer();
        container.addComponent(Calculator.class);
        container.addComponent(CalculatorServiceImpl.class);
        container.addComponent(InputExpressionValidatorImpl.class);
    }
}
