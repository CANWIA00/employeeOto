package com.canwia.employeeoto.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String surname;
    private Integer phone;
    private String mail;
    private Department department;
    private LocalDateTime localDateTime;






}
