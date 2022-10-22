package com.canwia.employeeoto.service;


import com.canwia.employeeoto.dto.EmployeeDto;
import com.canwia.employeeoto.dto.EmployeeDtoConverter;
import com.canwia.employeeoto.model.Department;
import com.canwia.employeeoto.model.Employee;
import com.canwia.employeeoto.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    private EmployeeService employeeService;


    private EmployeeRepository employeeRepository;
    private EmployeeDtoConverter employeeDtoConverter;

    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeDtoConverter = Mockito.mock(EmployeeDtoConverter.class);

        employeeService = new EmployeeService(employeeRepository,employeeDtoConverter);
    }

    @Test
    public void whenCreateEmployeeWithValidRequest_ItShouldReturnValidDto(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("name");
        employeeDto.setSurname("surname");
        employeeDto.setPhone(123123);
        employeeDto.setDepartment(Department.valueOf("IT"));
        employeeDto.setMail("aaa@aaaa");

        Employee employee = new Employee();
        employee.setName("name");
        employee.setSurname("surname");
        employee.setPhone(123123);
        employee.setDepartment(Department.valueOf("IT"));
        employee.setMail("aaa@aaaa");

        /* Definition Processes*/
        //Defined which methoods are going to run and return inside of the create function.
        Mockito.when(employeeDtoConverter.convertToEmployeeDto(employee)).thenReturn(employeeDto);
        Mockito.when(employeeDtoConverter.convertToEmployee(employeeDto)).thenReturn(employee);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        //Sent a Dto object to "mocked" service class and take a result for comparing with test result.
        EmployeeDto result = employeeService.create(employeeDto);

        //Compared to result of service and result of test
        Assertions.assertEquals(result,employeeDto);

        /* Operating of Processes that defined before  */
        Mockito.verify(employeeDtoConverter).convertToEmployeeDto(employee);
        Mockito.verify(employeeDtoConverter).convertToEmployee(employeeDto);
        Mockito.verify(employeeRepository).save(employee);

    }



    @Test
    public void whenFindByIdValidEmployeeDto_itShouldReturnValidDto(){
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setName("aaaa");
        employee.setSurname("aaaa");
        employee.setDepartment(Department.IT);
        employee.setPhone(123123);
        employee.setMail("aaa@aaa");
        employee.setLocalDateTime(LocalDateTime.now());

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("aaaa");
        employeeDto.setSurname("aaaa");
        employeeDto.setDepartment(Department.IT);
        employeeDto.setPhone(123123);
        employeeDto.setMail("aaa@aaa");

        Mockito.when(employeeRepository.findById(String.valueOf(employee.getId()))).thenReturn(Optional.of(employee));
        Mockito.when(employeeDtoConverter.convertToEmployeeDto(employee)).thenReturn(employeeDto);

        EmployeeDto result = employeeService.findById(String.valueOf(employee.getId()));

        Assertions.assertEquals(result,employeeDto);

        Mockito.verify(employeeRepository).findById(String.valueOf(employee.getId()));
        Mockito.verify(employeeDtoConverter).convertToEmployeeDto(employee);

    }


    @Test
    public void whenUpdateByIdValidEmployeeDto_ItShouldReturnValidDto(){
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setName("aaaa");
        employee.setSurname("aaaa");
        employee.setDepartment(Department.IT);
        employee.setPhone(123123);
        employee.setMail("aaa@aaa");
        employee.setLocalDateTime(LocalDateTime.now());

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("aaaa");
        employeeDto.setSurname("aaaa");
        employeeDto.setDepartment(Department.IT);
        employeeDto.setPhone(123123);
        employeeDto.setMail("aaa@aaa");


        Mockito.when(employeeRepository.findById(String.valueOf(employee.getId()))).thenReturn(Optional.of(employee));
        Mockito.when(employeeDtoConverter.convertToEmployeeDto(employee)).thenReturn(employeeDto);


        EmployeeDto result = employeeService.updateById(String.valueOf(employee.getId()),employeeDto);

        Assertions.assertEquals(result,employeeDto);

        Mockito.verify(employeeRepository).findById(String.valueOf(employee.getId()));
        Mockito.verify(employeeDtoConverter).convertToEmployeeDto(employee);



    }


}