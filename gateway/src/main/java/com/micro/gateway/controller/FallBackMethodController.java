package com.micro.gateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FallBackMethodController {

    //private static final String USERSERVICE = "USER-SERVICE";
    @GetMapping("/userServiceFallBack")
    @Retry(name = "USER-SERVICE")
    public String userServiceMethod(){
        return "User service is taking longer than expected" + "Please try again later";
    }
    int count = 1;
    @GetMapping("/departmentServiceFallBack")
    @Retry(name = "DEPARTMENT-SERVICE")
    public String departmentServiceMethod(){

        System.out.println("Retry method called ");
        System.out.println( count++);
        System.out.println("times at ");
        System.out.println( new Date());
        return "Department service is taking longer than expected" + "Please try again later";
    }
}
