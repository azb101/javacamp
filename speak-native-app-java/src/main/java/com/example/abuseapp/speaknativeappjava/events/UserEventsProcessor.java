package com.example.abuseapp.speaknativeappjava.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventsProcessor {

    @EventListener
    public void catchEvent(UserAddedEvent userAddedEvent){
        System.out.println("User added: " + userAddedEvent.getUser().toString());
    }

    @EventListener
    public void catchEvent(UserDeletedEvent userDeletedEvent) {
        System.out.println("User deleted: "+ userDeletedEvent.getId());
    }
}
