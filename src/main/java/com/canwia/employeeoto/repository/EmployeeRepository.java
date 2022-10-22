package com.canwia.employeeoto.repository;

import com.canwia.employeeoto.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
