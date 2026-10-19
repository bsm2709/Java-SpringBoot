package com.example.ProfilesAndFiltersBasics.Notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("Uber")
// so, for profile prod there is only one implement that is this Class
@Profile("prod")
public class UberNotification implements Notification{
    @Override
    public String notificationby() {
        return "Notified by Uber";
    }
}
