package com.ajax.springajax.repository;

import com.ajax.springajax.data.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
