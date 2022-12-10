package com.devendra.practice.service;

import com.devendra.practice.entity.Department;
import com.devendra.practice.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public String deleteDepartment(Long id);

    List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String name);
}
