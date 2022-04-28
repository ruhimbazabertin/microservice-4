package com.ajax.springajax.controller;

import com.ajax.springajax.data.JWTRequest;
import com.ajax.springajax.data.JWTResponse;
import com.ajax.springajax.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JWTController {
    @Autowired
    private JWTService jwtService;
    @PostMapping("/authenticate")
    public JWTResponse createJwtToken(@RequestBody JWTRequest jwtRequest) throws Exception{
        System.out.println("Heloo!!!");
        return jwtService.createJwtToken(jwtRequest);
    }

}
