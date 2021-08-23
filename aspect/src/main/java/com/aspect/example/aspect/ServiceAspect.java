package com.aspect.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.aspect.example.service.*.*(..))")
    public void beforeGiveMessageMethod(JoinPoint joinPoint) {
        System.out.println("before give message method: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }


    @After("execution(* com.aspect.example.service.*.*(..))")
    public void afterGiveMessageMethod(JoinPoint joinPoint) {
        System.out.println("after give message method: " + joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
    }
}
