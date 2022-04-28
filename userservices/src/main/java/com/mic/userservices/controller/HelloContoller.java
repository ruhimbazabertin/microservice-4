package com.mic.userservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloContoller {
    @GetMapping("/show")
    public String greeting(){

        return "hello";
    }
}
