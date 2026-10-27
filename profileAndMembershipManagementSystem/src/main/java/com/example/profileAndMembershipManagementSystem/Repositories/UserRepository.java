package com.example.profileAndMembershipManagementSystem.Repositories;

import com.example.profileAndMembershipManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    public Optional<User> findByIdAndIsDeletedFalse(long id);
}
