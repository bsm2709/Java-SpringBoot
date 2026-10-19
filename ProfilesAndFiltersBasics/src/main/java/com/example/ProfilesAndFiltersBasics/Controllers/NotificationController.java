package com.example.ProfilesAndFiltersBasics.Controllers;

import com.example.ProfilesAndFiltersBasics.Entity.UserDetails;
import com.example.ProfilesAndFiltersBasics.Notification.Notification;
import com.example.ProfilesAndFiltersBasics.Services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Notification")
public class NotificationController {

    NotificationService notificationService;
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    //Get message
    @GetMapping
    public ResponseEntity<String> getNotification(){

         return ResponseEntity.ok(notificationService.callNotification());
    }

    //Simple Post method to understand Filters
    @PostMapping
    public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails user)  {
            UserDetails userDetails = notificationService.createUser(user);
        return ResponseEntity.ok(userDetails);
    }
}
