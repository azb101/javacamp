package com.example.abuseapp.speaknativeappjava.services;

import com.example.abuseapp.speaknativeappjava.models.Phrase;
import org.springframework.stereotype.Service;

@Service
public interface PhraseService {
    Phrase add(Phrase phrase);
}

