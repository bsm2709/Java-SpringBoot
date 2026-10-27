package com.example.profileAndMembershipManagementSystem.Aspects;

import com.example.profileAndMembershipManagementSystem.CustomAnnotations.AuditableUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {
    @Before("@annotation(auditableUser)")
    public void logAuditTrail(JoinPoint joinPoint,
                              AuditableUser auditableUser) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AUDIT LOG] Security Event: A data modification method '" + methodName + "' was executed at " + java.time.LocalDateTime.now());
    }
}
