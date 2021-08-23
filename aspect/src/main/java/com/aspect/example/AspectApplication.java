package com.aspect.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }

}
