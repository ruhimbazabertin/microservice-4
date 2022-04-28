package com.ajax.springajax.user;

import com.ajax.springajax.data.Role;
import com.ajax.springajax.data.User;
import com.ajax.springajax.service.RoleService;
import com.ajax.springajax.service.UserService;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    void createRole(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDesciption("AdminRole");
        roleService.createNewRole(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDesciption("Default role newly created record");
        roleService.createNewRole(userRole);


        User adminUser = new User();
        adminUser.setUserFirstName("Ruhimbaza");
        adminUser.setUserLastName("Bertin");
        adminUser.setUserName("ruhimbazab@gmail.com");
        adminUser.setUserPassword("bertin123");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userService.registerNewUser(adminUser);

        User user = new User();
        user.setUserFirstName("Ahishakiye");
        user.setUserLastName("Aline");
        user.setUserName("aline@gmail.com");
        user.setUserPassword("aline123");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userService.registerNewUser(user);
    }
}
