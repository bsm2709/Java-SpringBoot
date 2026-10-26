package com.example.demoAOP.CustomAnnotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Marker Annotation
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//@Component
//public @interface TrackExecutionTime {
//    //Blank Space
//}

//Configured Annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TrackExecutionTime {
    //Blank Space
    long ExecutionTime() default 2000;

    String message() default "TrackExecutionTime";
}
