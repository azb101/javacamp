package com.epam.guessapp.common;

import com.epam.guessapp.generators.NumberGenerator;
import com.epam.guessapp.readers.InputReader;
import com.epam.guessapp.writers.OutputWriter;

public final class GuessApp {
    private static final int UPPER_BOUND = 100;

    private final NumberGenerator numberGenerator;
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public GuessApp(NumberGenerator numberGenerator,
                    InputReader inputReader,
                    OutputWriter outputWriter) {
        this.numberGenerator = numberGenerator;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run(){
        int targetNumber = numberGenerator.generateNextNumber(UPPER_BOUND);

        outputWriter.print(String.format("I generated number between: 1 and {0}. Guess the number", UPPER_BOUND));
        int temp = -1;

        while(temp != targetNumber){
            temp = inputReader.readNextNumber();

            if(temp > targetNumber){
                outputWriter.print("Your number is too high. Try again");
            }
            else if(temp < targetNumber){
                outputWriter.print("You number is too low. Try again");
            }
        }

        outputWriter.print("Bingo. The number is: " + targetNumber);
    }
}
