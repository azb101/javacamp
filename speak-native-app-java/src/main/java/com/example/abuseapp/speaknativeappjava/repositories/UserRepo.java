package com.example.abuseapp.speaknativeappjava.repositories;

import com.example.abuseapp.speaknativeappjava.models.User;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import javax.inject.Singleton;

@Repository
//@Singleton
//@Scope("session")
//@Scope("request")
/**
 * Scope is Spring feature
 * Singleton is JEE feature
 */
public interface UserRepo extends CrudRepository<User, UUID>{

}