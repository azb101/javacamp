package com.example.abuseapp.speaknativeappjava.logging;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    @Override
    public void info(String text) {
        System.out.println("simple logger : " + this.hashCode() +":" + text);
    }
}
