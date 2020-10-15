package com.example.abuseapp.speaknativeappjava.events;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class UserDeletedEvent extends ApplicationEvent{
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */

    private final UUID id;
    public UserDeletedEvent(Object source, UUID id) {
        super(source);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
