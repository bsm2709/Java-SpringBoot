package com.example.demoAOP.Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCuts {

    @Pointcut("within(com.example.demoAOP.Service.StudentService)")
    public void wrapRepositories(){

    }
}
