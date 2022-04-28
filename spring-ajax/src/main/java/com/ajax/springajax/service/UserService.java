package com.ajax.springajax.service;

import com.ajax.springajax.data.Role;
import com.ajax.springajax.data.User;
import com.ajax.springajax.repository.RoleRepository;
import com.ajax.springajax.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    private RoleRepository roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user){
        //Role role = roleRepo.findByRoleName("user").get();
        Set<Role> roles = new HashSet<>();
        //roles.add(role);
        user.setRoles(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
    return userRepo.save(user);
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
