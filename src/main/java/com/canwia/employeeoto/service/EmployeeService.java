package com.canwia.employeeoto.service;

import com.canwia.employeeoto.dto.EmployeeDto;
import com.canwia.employeeoto.dto.EmployeeDtoConverter;
import com.canwia.employeeoto.model.Employee;
import com.canwia.employeeoto.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoConverter employeeDtoConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoConverter employeeDtoConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoConverter = employeeDtoConverter;
    }


    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = employeeDtoConverter.convertToEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        return employeeDtoConverter.convertToEmployeeDto(employee);
    }

    public EmployeeDto findById(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){

            return employeeDtoConverter.convertToEmployeeDto(employee);
        }
        return employeeDtoConverter.convertToEmployeeDto(new Employee());
    }

    public List<EmployeeDto> findAll() {

        List<Employee> employee = employeeRepository.findAll();

        return employeeDtoConverter.convertToEmployeeDto(employee);
    }

    public EmployeeDto updateById(String id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null){
            employee.setName(employeeDto.getName());
            employee.setSurname(employeeDto.getSurname());
            employee.setPhone(employeeDto.getPhone());
            employee.setMail(employeeDto.getMail());
            employee.setDepartment(employeeDto.getDepartment());
            return employeeDtoConverter.convertToEmployeeDto(employee);
        }
        return employeeDtoConverter.convertToEmployeeDto(new Employee());





    }
}
