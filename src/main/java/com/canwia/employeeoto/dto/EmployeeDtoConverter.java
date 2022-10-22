package com.canwia.employeeoto.dto;

import com.canwia.employeeoto.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoConverter {
    public EmployeeDto convertToEmployeeDto(Employee employee){

       EmployeeDto employeeDto = new EmployeeDto();

       employeeDto.setName(employee.getName());
       employeeDto.setSurname(employee.getSurname());
       employeeDto.setPhone(employee.getPhone());
       employeeDto.setMail(employee.getMail());
       employeeDto.setDepartment(employee.getDepartment());

       return employeeDto;
    }

    public List<EmployeeDto> convertToEmployeeDto(List<Employee> employees){
        return employees.stream().map(this::convertToEmployeeDto).collect(Collectors.toList());
    }

    public Employee convertToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setPhone(employeeDto.getPhone());
        employee.setMail(employeeDto.getMail());
        employee.setDepartment(employee.getDepartment());

        return employee;
    }

    public List<Employee> convertToEmployee(List<EmployeeDto> employeeDtos){
        return employeeDtos.stream().map(this::convertToEmployee).collect(Collectors.toList());
    }
}
