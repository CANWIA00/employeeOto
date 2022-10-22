package com.canwia.employeeoto.controller;

import com.canwia.employeeoto.dto.EmployeeDto;
import com.canwia.employeeoto.dto.EmployeeDtoConverter;
import com.canwia.employeeoto.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeDtoConverter employeeDtoConverter;

    public EmployeeController(EmployeeService employeeService, EmployeeDtoConverter employeeDtoConverter) {
        this.employeeService = employeeService;
        this.employeeDtoConverter = employeeDtoConverter;
    }

    @PostMapping("/create")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.create(employeeDto);
    }

    @GetMapping("/find/{id}")
    public EmployeeDto findEmployee(@PathVariable String id){
        return employeeService.findById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDto> findAll(){
        return employeeService.findAll();
    }

    @PutMapping("update/{id}")
    public EmployeeDto updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateById(id,employeeDto);
    }
}
