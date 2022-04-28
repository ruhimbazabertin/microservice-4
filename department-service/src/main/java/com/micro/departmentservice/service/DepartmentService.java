package com.micro.departmentservice.service;

import com.micro.departmentservice.data.Department;
import com.micro.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departRepo;

    public DepartmentService(DepartmentRepository departRepo) {
    }

    public Department createDepart(Department depart) {
        log.info("inside createDepart method in DepartmentService");
       return departRepo.save(depart);
    }

    public List<Department> findAllDepartments(){

        return departRepo.findAll();
    }

    public Optional<Department> findDerpatById(Long id) {
        log.info("inside findDepart method in DepartmentService");
        return departRepo.findById(id);
    }
    public  void deleteDepart(Long id){
       Optional <Department> depart = departRepo.findById(id);
       try {
           if (depart.isPresent()){
               departRepo.deleteById(id);
               log.info("Department Deleted");
           }
       }catch (Exception ex){
           ex.getCause().getMessage();
       }

    }
}
