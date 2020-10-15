package com.epam.guessapp.readers;

import java.util.Scanner;

public class ConsoleInputReaderImpl implements InputReader {

    @Override
    public int readNextNumber() {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
