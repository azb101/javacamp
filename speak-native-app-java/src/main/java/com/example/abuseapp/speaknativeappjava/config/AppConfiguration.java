package com.example.abuseapp.speaknativeappjava.config;

import com.example.abuseapp.speaknativeappjava.logging.ConsoleLogger;
import com.example.abuseapp.speaknativeappjava.logging.Logger;
import com.example.abuseapp.speaknativeappjava.logging.TimedConsoleLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Scope("prototype")
    @Primary
    @Qualifier("simpleLogger")
    @Bean
    public Logger getSimpleLogger() {
        return new ConsoleLogger();
    }

    @Scope("prototype")
    @Qualifier("timedLogger")
    @Bean
    public Logger getTimedLogger() {
        System.out.println("getting TimedLogger");
        return new TimedConsoleLogger();
    }
}
