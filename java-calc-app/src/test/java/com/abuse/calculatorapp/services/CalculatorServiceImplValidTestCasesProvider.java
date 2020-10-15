package com.abuse.calculatorapp.services;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class CalculatorServiceImplValidTestCasesProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("1+1", 2.0),
                Arguments.of("((1+1))", 2.0),
                Arguments.of("(1)+(1)", 2.0),
                Arguments.of("((1)+(1))", 2.0),
                Arguments.of("1+1+(1+1)", 4.0),
                Arguments.of("1+1+(1+1)*2", 6.0),
                Arguments.of("(1+2+(1+1)*2)", 7.0),
                Arguments.of("(1+2+3+4+5)", 15.0),
                Arguments.of("(1+2)+(3+4+5)", 15.0),
                Arguments.of("((1+2)+(3+4+5))", 15.0),
                Arguments.of("((1+2)+(3+4+5)-10)", 5.0),
                Arguments.of("((1+2)*(3+4+5)-10)", 26.0),
                Arguments.of("1*2/5", 0.4),
                Arguments.of("2/5+1-10/2", -3.6),
                Arguments.of("2/(5+1)-10/2", -4.666666666666667),
                Arguments.of("(2/(5+1))-10/2", -4.666666666666667),
                Arguments.of("(2/(1))-10/2", -3),
                Arguments.of("1*25+3+(4/3)", 29.333333333333332),
                Arguments.of("1", 1),
                Arguments.of("(4)", 4)
        );
    }
}
