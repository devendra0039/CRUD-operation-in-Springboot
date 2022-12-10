package com.devendra.practice.controller;

import com.devendra.practice.entity.Department;
import com.devendra.practice.error.DepartmentNotFoundException;
import com.devendra.practice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private  final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment (@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id ){
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId ,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable String name){
        return  departmentService.fetchDepartmentByName(name);
    }
}
