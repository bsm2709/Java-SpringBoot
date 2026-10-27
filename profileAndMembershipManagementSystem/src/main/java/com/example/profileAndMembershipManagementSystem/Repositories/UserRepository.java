package com.example.profileAndMembershipManagementSystem.Repositories;

import com.example.profileAndMembershipManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
}
