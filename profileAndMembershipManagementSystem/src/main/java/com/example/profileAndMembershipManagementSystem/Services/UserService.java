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
        user.setActive(true);
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

    //Edit particular Active student by id
    public User editActiveUser(User user,long id){
        User originalUser = userRepository.getReferenceById(id);

        //Edit or alter details
        originalUser.setEmail(user.getEmail());
        originalUser.setMembershipTier(user.getMembershipTier());

        userRepository.save(originalUser);

        return originalUser;
    }

    //Soft-Delete
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
