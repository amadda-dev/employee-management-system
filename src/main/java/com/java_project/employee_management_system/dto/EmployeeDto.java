package com.java_project.employee_management_system.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private Long departmentId;
    private String departmentName;
}