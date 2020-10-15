package com.abuse.calculatorapp.services;

import com.abuse.calculatorapp.services.exceptions.DivisionByZeroException;
import com.abuse.calculatorapp.validation.InputExpressionValidator;

import java.util.*;

public class CalculatorServiceImpl implements CalculatorService {
    private final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error has occured while calculating expression %1$s";
    private final String DIVISION_BY_ZERO_MESSAGE = "Expression '%1$s' implies division by zero";

    private final InputExpressionValidator inputExpressionValidator;

    public CalculatorServiceImpl(InputExpressionValidator inputExpressionValidator) {
        this.inputExpressionValidator = inputExpressionValidator;
    }

    @Override
    public CalculationResult solve(String expression) {
        var result = new CalculationResult();

        var validationResult = inputExpressionValidator.validate(expression);
        if (!validationResult.isEmpty()) {
            result.setErrors(validationResult);
            return result;
        }

        evaluateAndSetValue(expression, result);

        return result;
    }

    private void evaluateAndSetValue(String expression, CalculationResult result) {
        Queue<Character> q = new LinkedList<>();

        for (char sym : expression.toCharArray()) {
            if (sym == ' ')
                continue;
            q.offer(sym);
        }

        q.offer('+');

        try {
            result.setValue(calculate(q));
        } catch (DivisionByZeroException exception) {
            result.addError(new GeneralError(String.format(DIVISION_BY_ZERO_MESSAGE, expression), exception));
        } catch (Exception exception) {
            result.addError(new GeneralError(String.format(UNEXPECTED_ERROR_MESSAGE, expression), exception));
        }
    }

    private double calculate(Queue<Character> q) {
        if (q.size() == 0)
            return 0;

        Deque<Double> chunks = new ArrayDeque<>();

        double num = 0.0;
        char sign = '+';
        while (q.size() != 0) {
            char nextSym = q.poll();

            if (Character.isDigit(nextSym)) {
                num = num * 10 + (nextSym - '0');
            } else {
                if (nextSym == '+' || nextSym == '-' || nextSym == '*' || nextSym == '/') {
                    if (sign == '+') {
                        chunks.push(num);
                    } else if (sign == '-') {
                        chunks.push(-num);
                    } else if (sign == '*') {
                        chunks.push(chunks.pop() * num);
                    } else if (sign == '/') {
                        double a = chunks.pop();
                        if (num == 0)
                            throw new DivisionByZeroException();

                        chunks.push(a / num);
                    }

                    num = 0;
                    sign = nextSym;
                } else if (nextSym == '(') {
                    num = calculate(q);
                } else if (nextSym == ')') {
                    if (sign == '+') {
                        chunks.push(num);
                    } else if (sign == '-') {
                        chunks.push(-num);
                    } else if (sign == '*') {
                        chunks.push(chunks.pop() * num);
                    } else if (sign == '/') {
                        double a = chunks.pop();
                        if (num == 0)
                            throw new DivisionByZeroException();

                        chunks.push(a / num);
                    }

                    break;
                }
            }
        }

        double res = 0.0;
        while (chunks.size() != 0) {
            res += chunks.pop();
        }

        return res;
    }
}
