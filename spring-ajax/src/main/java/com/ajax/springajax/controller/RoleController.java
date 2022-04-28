package com.ajax.springajax.controller;

import com.ajax.springajax.data.Role;
import com.ajax.springajax.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")

public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){

        return roleService.createNewRole(role);
    }
}
