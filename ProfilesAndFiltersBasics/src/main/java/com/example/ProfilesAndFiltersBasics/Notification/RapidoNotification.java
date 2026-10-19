package com.example.ProfilesAndFiltersBasics.Notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("Rapido")
//No conflict even while not writing primary or qualifier tags because this is managed by Profile tag because for Notification interface there are 2 implements but it is different for diffrent Profiles
// so, for profile dev, default there is only one implement that is this Class
@Profile({"dev", "default"})
public class RapidoNotification implements Notification{
    @Override
    public String notificationby() {
        return "Notified by Rapido";
    }

}
