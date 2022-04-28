package com.mic.userservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserViewController {

    @GetMapping("/microservices")
    public String homepage(){

        return "microservice";
    }
}
