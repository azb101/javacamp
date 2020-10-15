package com.abuse.calculatorapp.calculators;

import com.abuse.calculatorapp.services.CalculatorService;

import java.util.Scanner;

public class Calculator {

    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        String nextExpression;
        while ((nextExpression = readNextExpression()) != null) {
            if (nextExpression.length() == 0) {
                System.out.print("[APP] Nothing was entered. So quit");
                break;
            }

            var result = calculatorService.solve(nextExpression);
            result.print();
        }
    }

    private String readNextExpression() {
        System.out.println("[APP] Enter next expression to calculates: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
