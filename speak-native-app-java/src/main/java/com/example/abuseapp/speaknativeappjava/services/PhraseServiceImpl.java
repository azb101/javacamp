package com.example.abuseapp.speaknativeappjava.services;

import com.example.abuseapp.speaknativeappjava.models.Phrase;
import com.example.abuseapp.speaknativeappjava.repositories.PhraseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class PhraseServiceImpl implements PhraseService{

    private final PhraseRepo phraseRepo;

    @Autowired
    public PhraseServiceImpl(PhraseRepo phraseRepo) {
        this.phraseRepo = phraseRepo;
    }

    @Override
    public Phrase add(Phrase phrase) {
        return phraseRepo.save(phrase);
    }
}
