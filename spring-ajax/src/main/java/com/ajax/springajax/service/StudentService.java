package com.ajax.springajax.service;

import com.ajax.springajax.data.Student;
import com.ajax.springajax.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    public void createStudent(Student student){
        studentRepo.save(student);
    }
    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }
    public Student findStudent(Long id){
        return studentRepo.getById(id);
    }
    public Student updateStudent(Student student){

        return studentRepo.save(student);
    }
    public void deleteStudent(Student student){
        studentRepo.delete(student);

    }
}
