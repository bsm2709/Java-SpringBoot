package com.example.profileAndMembershipManagementSystem.Dtos;


public class UserRequestDto {

    private String email;
    private String membershipTier;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }
}
