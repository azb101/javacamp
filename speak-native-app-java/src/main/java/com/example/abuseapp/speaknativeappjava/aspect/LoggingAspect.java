package com.example.abuseapp.speaknativeappjava.aspect;


import com.example.abuseapp.speaknativeappjava.logging.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAspect {

    @Autowired
    private Logger logger;

    @Before("execution(public String index(*))")
    public void LoggingAdvice() {
        logger.info("Users index pages has been requested");
    }
}
