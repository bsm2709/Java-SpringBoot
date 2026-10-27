package com.example.profileAndMembershipManagementSystem.CustomAnnotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditableUser {
}
