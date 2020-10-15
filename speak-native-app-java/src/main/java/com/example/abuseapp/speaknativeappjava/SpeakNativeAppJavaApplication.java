package com.example.abuseapp.speaknativeappjava;

import com.example.abuseapp.speaknativeappjava.logging.Logger;
import com.example.abuseapp.speaknativeappjava.repositories.PhraseRepo;
import com.example.abuseapp.speaknativeappjava.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

@SpringBootApplication
public class SpeakNativeAppJavaApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpeakNativeAppJavaApplication.class, args);

		var logger = context.getBean(Logger.class);

		System.out.println(logger.getClass());
	}
}
