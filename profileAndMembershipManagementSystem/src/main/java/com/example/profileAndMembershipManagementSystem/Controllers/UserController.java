package com.example.profileAndMembershipManagementSystem.Controllers;

import com.example.profileAndMembershipManagementSystem.Entity.User;
import com.example.profileAndMembershipManagementSystem.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Add User
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUserToRepo(user));
    }

    //Get all Active users
    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers(){
        return ResponseEntity.ok(userService.fetchAllActiveUsers());
    }

    //Get perticular User by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getActiveUser(@PathVariable long id){
        return ResponseEntity.ok(userService.fetchActiveUser(id));
    }
}
