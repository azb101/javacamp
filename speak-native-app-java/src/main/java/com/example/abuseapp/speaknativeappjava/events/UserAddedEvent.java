package com.example.abuseapp.speaknativeappjava.events;

import com.example.abuseapp.speaknativeappjava.models.User;
import org.springframework.context.ApplicationEvent;

public class UserAddedEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */

    private final User user;

    public UserAddedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
