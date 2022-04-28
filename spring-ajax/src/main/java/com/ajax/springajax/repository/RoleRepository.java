package com.ajax.springajax.repository;

import com.ajax.springajax.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //Create a native query for this method in future.
    //Optional<Role> findByRoleName();
}
