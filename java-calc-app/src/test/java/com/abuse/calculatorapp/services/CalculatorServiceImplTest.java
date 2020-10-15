package com.abuse.calculatorapp.services;

import com.abuse.calculatorapp.validation.InputExpressionValidator;
import com.abuse.calculatorapp.validation.ValidationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CalculatorServiceImplTest {
    private final static String INVALID_BRACKETS_MESSAGE = "Expression contains invalid brackets";
    private final String DIVISION_BY_ZERO_MESSAGE = "Expression '%1$s' implies division by zero";

    @Mock
    private InputExpressionValidator inputExpressionValidator;
    private CalculatorServiceImpl sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new CalculatorServiceImpl(inputExpressionValidator);
    }

    @Test
    void solve_returnsResultWithInvalidState_WhenValidatorReturnsErrors() {
        var expression = "some random expression";
        var errors = getInvalidBracketsErrors();
        when(inputExpressionValidator.validate(expression)).thenReturn(errors);

        var result = sut.solve(expression);

        assertThat(result)
                .isNotNull()
                .isInstanceOf(CalculationResult.class);
        assertThat(result.getType())
                .isEqualTo(CalculationResultType.INVALID);
        assertThat(result.getErrors())
                .isNotNull()
                .isNotEmpty();

        assertEquals(1, result.getErrors().size());
        assertEquals(ValidationError.class, result.getErrors().get(0).getClass());
        assertEquals(INVALID_BRACKETS_MESSAGE, result.getErrors().get(0).getMessage());
        verify(inputExpressionValidator).validate(expression);
    }

    private static List<CalculationError> getInvalidBracketsErrors() {
        var errors = new ArrayList<CalculationError>();
        errors.add(new ValidationError(INVALID_BRACKETS_MESSAGE));
        return errors;
    }

    @DisplayName("Should return result for specified expressions")
    @ParameterizedTest
    @ArgumentsSource(CalculatorServiceImplValidTestCasesProvider.class)
    void solve_returnsProperResult_ForFollowingExpressions(String expression, double resultValue) {
        when(inputExpressionValidator.validate(expression)).thenReturn(new ArrayList<>());

        var result = sut.solve(expression);

        assertNotNull(result);
        assertEquals(CalculationResult.class, result.getClass());
        assertEquals(CalculationResultType.VALID, result.getType());
        assertEquals(0, result.getErrors().size());
        assertEquals(resultValue, result.getValue());
        verify(inputExpressionValidator).validate(expression);
    }

    @DisplayName("Should return exception with division by zero message for specified expressions")
    @ParameterizedTest
    @ValueSource(strings = {"1/(1-1)", "1*2*2+4-100/0", "100/0", "(1-1)/0", "(1-2)/(5-5)"})
    void solve_returnsResultWithDivisionByZeroError_ForFollowingExpressions(String expression) {
        when(inputExpressionValidator.validate(expression)).thenReturn(new ArrayList<>());

        var result = sut.solve(expression);

        assertNotNull(result);
        assertEquals(CalculationResult.class, result.getClass());
        assertEquals(CalculationResultType.INVALID, result.getType());
        assertEquals(1, result.getErrors().size());
        assertEquals(0.0, result.getValue());
        assertEquals(GeneralError.class, result.getErrors().get(0).getClass());
        assertEquals(String.format(DIVISION_BY_ZERO_MESSAGE, expression), result.getErrors().get(0).getMessage());
    }
}