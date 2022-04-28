package com.ajax.springajax.service;

import com.ajax.springajax.data.Role;
import com.ajax.springajax.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepo;
    public Role createNewRole(Role role){
    return roleRepo.save(role);
    }
}
