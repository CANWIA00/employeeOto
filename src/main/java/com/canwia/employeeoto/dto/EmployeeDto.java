package com.canwia.employeeoto.dto;

import com.canwia.employeeoto.model.Department;
import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String surname;
    private Integer phone;
    private String mail;
    private Department department;
}
