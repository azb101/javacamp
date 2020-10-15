package com.abuse.calculatorapp.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InputExpressionValidatorImplTest {

    private final String EMPTY_EXPRESSION_MESSAGE = "Expression is empty";
    private final String INVALID_SYMBOLS_MESSAGE = "Expression contains some invalid symbols";
    private final String INVALID_BRACKETS_MESSAGE = "Expression contains invalid brackets";

    private InputExpressionValidatorImpl sut;

    @BeforeEach
    void setUp() {
        sut = new InputExpressionValidatorImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @NullAndEmptySource
    void validate_returnsValidationErrorWithEmptyResponse_WhenNullExpressionProvided(String expression) {
        var result = sut.validate(expression);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(ValidationError.class, result.get(0).getClass());
        assertEquals(EMPTY_EXPRESSION_MESSAGE, result.get(0).getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+2%", "3+4*2*a", "2/24_", "a134 ", "23@", "e", "adsf", "!234+32", "±3", "d>"})
    void validate_returnsValidationErrorWithInvalidMessageResponse_WhenInvalidSymbolsProvided(String expression) {
        var result = sut.validate(expression);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(ValidationError.class, result.get(0).getClass());
        assertEquals(INVALID_SYMBOLS_MESSAGE, result.get(0).getMessage());
    }

    @Test
    void validate_doesNotReturnValidationErrorWithInvalidMessageResponse_WhenApppriateSymbolsProvided() {
        var expression = "0123456789()+-*/";

        var result = sut.validate(expression);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"(1+)2)", "(1", ")1+2)", "( 1 + 2)(", "(()))", "(())())", ")(", "(()", "(((()))"})
    void validate_returnsValidationErrorWithInvalidBracketsResponse_WhenInvalidBracketsProvided(String expression) {
        var result = sut.validate(expression);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(ValidationError.class, result.get(0).getClass());
        assertEquals(INVALID_BRACKETS_MESSAGE, result.get(0).getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "()()", "((()))", "(()())", "(())", "((())())", "()()() ()", "((()))",
            "(1+1)+(2+2)", "(1+1)", "(1)", "1+2", "(1+2+(2+3)+(2+2))+2*2"})
    void validate_doesNotReturnValidationErrorWithInvalidBracketsResponse_WhenValidBracketsProvided(String expression) {
        var result = sut.validate(expression);

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}