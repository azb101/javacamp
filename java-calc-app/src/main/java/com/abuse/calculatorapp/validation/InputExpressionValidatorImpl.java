package com.abuse.calculatorapp.validation;

import com.abuse.calculatorapp.services.CalculationError;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class InputExpressionValidatorImpl implements InputExpressionValidator {
    private final String EMPTY_EXPRESSION_MESSAGE = "Expression is empty";
    private final String INVALID_SYMBOLS_MESSAGE = "Expression contains some invalid symbols";
    private final String INVALID_BRACKETS_MESSAGE = "Expression contains invalid brackets";
    private final HashSet<Character> VALID_SYMBOLS = new HashSet<>();

    public InputExpressionValidatorImpl() {
        VALID_SYMBOLS.add('+');
        VALID_SYMBOLS.add('-');
        VALID_SYMBOLS.add('*');
        VALID_SYMBOLS.add('/');
        VALID_SYMBOLS.add(' ');
        VALID_SYMBOLS.add('(');
        VALID_SYMBOLS.add(')');
    }

    @Override
    public List<CalculationError> validate(String expression) {
        ArrayList<CalculationError> result = new ArrayList<>();

        if (StringUtils.isBlank(expression)) {
            result.add(new ValidationError(EMPTY_EXPRESSION_MESSAGE));
            return result;
        }

        if (hasInvalidSymbols(expression)) {
            result.add(new ValidationError(INVALID_SYMBOLS_MESSAGE));
            return result;
        }

        if (bracketsAreInvalid(expression)) {
            result.add(new ValidationError(INVALID_BRACKETS_MESSAGE));
            return result;
        }

        return result;
    }

    private boolean bracketsAreInvalid(String expression) {
        Deque<Character> dq = new ArrayDeque<>();
        int n = expression.length();

        for (int i = 0; i < n; i++) {
            char sym = expression.charAt(i);

            if (sym == ')' && dq.size() != 0 && dq.peek() == '(')
                dq.pop();
            else if (sym == '(' || sym == ')')
                dq.push(sym);
        }

        return dq.size() != 0;
    }

    private boolean hasInvalidSymbols(String expression) {
        int n = expression.length();

        for (int i = 0; i < n; i++) {
            char sym = expression.charAt(i);

            if (!Character.isDigit(sym) && !VALID_SYMBOLS.contains(sym))
                return true;
        }

        return false;
    }
}
