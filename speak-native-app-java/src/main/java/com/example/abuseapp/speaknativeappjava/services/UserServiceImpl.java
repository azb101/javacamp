package com.example.abuseapp.speaknativeappjava.services;

import com.example.abuseapp.speaknativeappjava.events.UserAddedEvent;
import com.example.abuseapp.speaknativeappjava.events.UserDeletedEvent;
import com.example.abuseapp.speaknativeappjava.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import com.example.abuseapp.speaknativeappjava.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
@Service
public class UserServiceImpl implements  UserService{

    private final UserRepo userRepo;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserServiceImpl(UserRepo userRepo,
                           ApplicationEventPublisher applicationEventPublisher)
    {
        this.userRepo = userRepo;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public List<User> getAll()
    {
        return (List<User>)userRepo.findAll();
    }

    public User createUser(String email, String password)
    {
        var user = new User();
        user.setEmail(email);
        user.setPassword(password);

        var createdUser = userRepo.save(user);

        applicationEventPublisher.publishEvent(new UserAddedEvent(this, createdUser));

        return createdUser;
    }

    public void delete(UUID id)
    {
        userRepo.deleteById(id);
        applicationEventPublisher.publishEvent(new UserDeletedEvent(this, id));
    }
}
