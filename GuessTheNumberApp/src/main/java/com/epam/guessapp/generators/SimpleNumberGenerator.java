package com.epam.guessapp.generators;

import java.util.Random;

public class SimpleNumberGenerator implements NumberGenerator {

    private Random random;

    public SimpleNumberGenerator(Random random)
    {
        this.random = random;
    }

    @Override
    public int generateNextNumber(int upperbound) {
        return random.nextInt(upperbound);
    }
}
