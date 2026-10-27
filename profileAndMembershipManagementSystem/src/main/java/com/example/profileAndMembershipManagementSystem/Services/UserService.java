package com.example.profileAndMembershipManagementSystem.Services;

import com.example.profileAndMembershipManagementSystem.Dtos.UserRequestDto;
import com.example.profileAndMembershipManagementSystem.Dtos.UserResponseDto;
import com.example.profileAndMembershipManagementSystem.Entity.User;
import com.example.profileAndMembershipManagementSystem.Exceptions.UserNotFoundException;
import com.example.profileAndMembershipManagementSystem.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //To add User to database
    public UserResponseDto addUserToRepo(UserRequestDto userRequestDto){
        User user = convertRequestDtoToUser(userRequestDto);
        userRepository.save(user);

        return convertUserToResponseDto(user);
    }

    //Get all active students
    public List<User> fetchAllActiveUsers(){
        return userRepository.findAll();
    }

    //Get particular Active student by id
    public UserResponseDto fetchActiveUser(long id){
        User user = userRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new UserNotFoundException("User Not found"));
        return convertUserToResponseDto(user);
    }


    //Edit particular Active student by id
    public UserResponseDto editActiveUser(UserRequestDto userRequestDto,long id){
        User originalUser = userRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new UserNotFoundException("User Not found"));

        //Edit or alter details
        originalUser.setEmail(userRequestDto.getEmail());
        originalUser.setMembershipTier(userRequestDto.getMembershipTier());
        originalUser.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        userRepository.save(originalUser);

        return convertUserToResponseDto(originalUser);

    }

    //Soft-Delete
    public void softDelete(long id){
        User user = userRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new UserNotFoundException("User Not found"));
        user.setDeleted(true);
        userRepository.save(user);
    }

    //Delete
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }




    //Convertion From UserRequestDto to User
    public User convertRequestDtoToUser(UserRequestDto userRequestDto){
        User user = new User();

        //Assign values
        user.setEmail(userRequestDto.getEmail());
        user.setMembershipTier(userRequestDto.getMembershipTier());

        //Default values while creating
        user.setActive(true);
        user.setDeleted(false);
        user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        user.setUpdatedAt(String.valueOf(LocalDateTime.now()));

        return user;
    }

    //convertion From User to UserResponseDto
    public UserResponseDto convertUserToResponseDto(User user){
        UserResponseDto userResponseDto= new UserResponseDto();

        //Assign values
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setMembershipTier(user.getMembershipTier());
        userResponseDto.setActive(user.isActive());
        userResponseDto.setCreatedAt(user.getCreatedAt());
        userResponseDto.setUpdatedAt(user.getUpdatedAt());

        return userResponseDto;
    }
}
