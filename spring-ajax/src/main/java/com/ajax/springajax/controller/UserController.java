package com.ajax.springajax.controller;

import com.ajax.springajax.data.User;
import com.ajax.springajax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userservice;
    @PostMapping("/createNewUser")
    public User registerNewUser(@RequestBody User user){
    return userservice.registerNewUser(user);
    }
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/authenticate/admin")
    public String forAdmin(){

        return "This URL is only accessible by Admin";
    }
    //@PreAuthorize("hasRole('User')")
    @PreAuthorize("hasAnyRole('Admin','user')")
    @GetMapping("/authenticate/user")
    public String forUser(){

        return "This URL is only accessible by Normal User";
    }
}
