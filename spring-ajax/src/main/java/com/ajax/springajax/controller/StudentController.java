package com.ajax.springajax.controller;

import com.ajax.springajax.data.Student;
import com.ajax.springajax.repository.StudentRepository;
import com.ajax.springajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@ResponseBody
@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student-page")
    public String homepage(){
        return "studentpage";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "studentpage";
    }
    @GetMapping("/all")
    public @ResponseBody List<Student> getAllStudent()
    {
        List<Student> students=studentService.findAllStudents();

        return students;
    }
}
