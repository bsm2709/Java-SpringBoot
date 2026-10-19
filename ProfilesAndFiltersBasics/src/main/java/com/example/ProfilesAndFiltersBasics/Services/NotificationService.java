package com.example.ProfilesAndFiltersBasics.Services;


import com.example.ProfilesAndFiltersBasics.Notification.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Value("${application.welcome.message}")
    private String message;

    Notification notification;

    public NotificationService(/*@Qualifier("Uber") */ Notification notification){
        this.notification = notification;
    }

    public String callNotification(){
        return   message + " "+notification.notificationby() ;
    }
}
