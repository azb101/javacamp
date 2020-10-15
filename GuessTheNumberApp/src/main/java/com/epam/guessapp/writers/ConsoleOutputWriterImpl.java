package com.epam.guessapp.writers;

public class ConsoleOutputWriterImpl implements OutputWriter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
