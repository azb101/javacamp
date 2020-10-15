package com.epam.guessapp;

import com.epam.guessapp.common.GuessApp;
import com.epam.guessapp.generators.*;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.*;
import com.epam.guessapp.readers.ConsoleInputReaderImpl;
import com.epam.guessapp.writers.ConsoleOutputWriterImpl;

import java.util.Random;

class Launcher {
    private static MutablePicoContainer container;

    public static void main(String[] args) {
        ConfigureDependencies();

        GuessApp guessApp = (GuessApp) container.getComponent(GuessApp.class);
        guessApp.run();
    }

    private static void ConfigureDependencies() {
        container = new DefaultPicoContainer();
        container.addComponent(GuessApp.class);
        container.addComponent(Random.class);
        container.addComponent(SimpleNumberGenerator.class);
        container.addComponent(ConsoleInputReaderImpl.class);
        container.addComponent(ConsoleOutputWriterImpl.class);

    }
}
