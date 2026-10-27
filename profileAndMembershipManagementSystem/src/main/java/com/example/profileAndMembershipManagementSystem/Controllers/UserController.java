package com.example.profileAndMembershipManagementSystem.Controllers;

import com.example.profileAndMembershipManagementSystem.Dtos.UserRequestDto;
import com.example.profileAndMembershipManagementSystem.Dtos.UserResponseDto;
import com.example.profileAndMembershipManagementSystem.Entity.User;
import com.example.profileAndMembershipManagementSystem.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Add User
    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.addUserToRepo(userRequestDto));
    }

    //Get all Active users
    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers(){
        return ResponseEntity.ok(userService.fetchAllActiveUsers());
    }

    //Get perticular User by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getActiveUser(@PathVariable long id){
        return ResponseEntity.ok(userService.fetchActiveUser(id));
    }

    //Edit user details
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> editActiveUser(@RequestBody UserRequestDto userRequestDto,
                                               @PathVariable long id){
        return ResponseEntity.ok(userService.editActiveUser(userRequestDto,id));
    }

    //Soft-Delete
    @PatchMapping("/{id}")
    public void softDeleteUser(@PathVariable long id){
        userService.softDelete(id);

    }

    //Delete User
    @DeleteMapping("/{id}")
    public void deleteActiveUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
