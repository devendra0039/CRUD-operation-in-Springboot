package com.devendra.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    private  String departmentName;

    private  String departmentAddress;

    private  String departmentCode;

//    public Long getDepartmentId() {return departmentId;}
//
//    public void setDepartmentId(Long DepartmentId) {
//        departmentId = DepartmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String DepartmentName) {
//        departmentName = DepartmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String DepartmentAddress) {
//        departmentAddress = DepartmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String DepartmentCode) {
//        departmentCode = DepartmentCode;
//    }
//
//    public Department(Long DepartmentId, String DepartmentName, String DepartmentAddress, String DepartmentCode) {
//        departmentId = DepartmentId;
//        departmentName = DepartmentName;
//        departmentAddress = DepartmentAddress;
//        departmentCode = DepartmentCode;
//    }
//
//    public Department() {
//    }

//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
