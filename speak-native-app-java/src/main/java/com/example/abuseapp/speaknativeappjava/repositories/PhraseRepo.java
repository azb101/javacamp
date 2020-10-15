package com.example.abuseapp.speaknativeappjava.repositories;

import com.example.abuseapp.speaknativeappjava.models.Phrase;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)

public interface PhraseRepo extends CrudRepository<Phrase, UUID> {

    //@Query("SELECT p FROM Phrase p where p.user.id=:userId")
    //List<Phrase> getByUserId(UUID userId);
}
