package com.example.abuseapp.speaknativeappjava.logging;

import java.time.LocalDateTime;

public class TimedConsoleLogger implements Logger {
    @Override
    public void info(String text) {
        System.out.println(LocalDateTime.now() + ": " + this.hashCode() +":" + text);
    }
}
