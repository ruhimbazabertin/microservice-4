package com.micro.departmentservice.repository;

import com.micro.departmentservice.data.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
