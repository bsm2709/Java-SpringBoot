package com.example.profileAndMembershipManagementSystem.CustomAnnotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditableUser {

}
