package com.example.abuseapp.speaknativeappjava.services;

import com.example.abuseapp.speaknativeappjava.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User createUser(String email, String password);
    void delete(UUID id);
}
