package com.example.profileAndMembershipManagementSystem.Services;

import com.example.profileAndMembershipManagementSystem.Entity.User;
import com.example.profileAndMembershipManagementSystem.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //To add User to database
    public User addUserToRepo(User user){

        return userRepository.save(user);
    }

    //Get all active students
    public List<User> fetchAllActiveUsers(){
        return userRepository.findAll();
    }

    //Get particular Active student by id
    public Optional<User> fetchActiveUser(long id){
        return userRepository.findById(id);
    }
    
}
