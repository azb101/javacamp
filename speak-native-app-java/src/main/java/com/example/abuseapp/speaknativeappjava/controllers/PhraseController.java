package com.example.abuseapp.speaknativeappjava.controllers;

import com.example.abuseapp.speaknativeappjava.models.Phrase;
import com.example.abuseapp.speaknativeappjava.repositories.PhraseRepo;
import com.example.abuseapp.speaknativeappjava.services.PhraseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    @Inject
    public PhraseController(PhraseService phraseService)
    {
        this.phraseService = phraseService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Phrase createPhrase(@RequestBody Phrase phrase) throws Exception {
        var obj = phraseService.add(phrase);
        if(obj == null)
            throw new Exception("phrase was not created");

        return obj;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Phrase> handleError(Exception ex){
        ex.getSuppressed();
        return ResponseEntity.badRequest().build();
    }

    @ControllerAdvice(assignableTypes = Phrase.class)
    class ControllerAspect{

    }
}
