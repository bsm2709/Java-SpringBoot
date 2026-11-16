package com.example.course_access_gateway.CustomAnnotations;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Component
public @interface AuditableAction {
    String actionDescription();
}
