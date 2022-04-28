package com.ajax.springajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/")
public class AuthController {
    @GetMapping("/sign-in")
    public String signInPage(){

        return "login";
    }
    @GetMapping("/sign-up")
    public String signUpPage(){

        return "register";
    }
}
