package com.devendra.practice.service;

import com.devendra.practice.entity.Department;
import com.devendra.practice.error.DepartmentNotFoundException;
import com.devendra.practice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted: " +id;
    }



    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
//      return  departmentRepository.findById(id).orElse(null);
//        return departmentRepository.findById(id).get();
       Optional<Department> department = departmentRepository.findById(id);
       if (!department.isPresent()){
           throw new DepartmentNotFoundException("Department Not Available");
       }
       return department.get();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return  departmentRepository.findByDepartmentName(name);
    }


}
