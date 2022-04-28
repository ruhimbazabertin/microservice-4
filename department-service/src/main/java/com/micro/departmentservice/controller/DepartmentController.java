package com.micro.departmentservice.controller;

import com.micro.departmentservice.data.Department;
import com.micro.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/departments")

public class DepartmentController {
    @Autowired
    private DepartmentService departService;

    @PostMapping("/create")
    private Department createDepart(@RequestBody  Department depart){

        return departService.createDepart(depart);
    }
    @RequestMapping("/{id}")
    private Optional<Department> findDepartment(@PathVariable("id") Long id){

        return departService.findDerpatById(id);
    }
    @RequestMapping("/all")
    private List<Department> findAllDeparts(){
        return departService.findAllDepartments();
    }
    @DeleteMapping("/delete/{id}")
    private void deleteDepart(@PathVariable("id") Long id){
        departService.deleteDepart(id);
    }
}
