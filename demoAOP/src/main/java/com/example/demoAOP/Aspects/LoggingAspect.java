package com.example.demoAOP.Aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

@Component
@Aspect
public class LoggingAspect {

    //Logging all methods in StudentServices
    @Before("execution(com.example.demoAOP.Entity.Student com.example.demoAOP.Service.StudentService.*(..) )")
    public void logBefore(){
        System.out.println("Intercepted Methods...");
    }

    @After("within(com.example.demoAOP.Service.StudentService)")
    public void logAfter(){
        System.out.println("Exiting Methods");
    }


    //Authenticating every Request for service classes( or any class having @Service annotation)
//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void authenticateKeyForService(JoinPoint joinPoint){
//        System.out.println("Entering to check authentication....");
//       Object key = joinPoint.getArgs();
//       String originalString = key.toString();
//        System.out.println(originalString);
//    }

    //Entering to db to check time taken by it to execute
    @Around("PointCuts.wrapRepositories()")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
        //Before
        long startTime = System.currentTimeMillis();

       Object result = pjp.proceed();

       //After
       long endTime = System.currentTimeMillis();

        System.out.println("Total time take: "+ (endTime - startTime)+ " ms");

       return result;
    }

}
