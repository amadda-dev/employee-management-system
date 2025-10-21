package com.java_project.employee_management_system.mapper;

import com.java_project.employee_management_system.dto.EmployeeDto;
import com.java_project.employee_management_system.entity.Employee;
import com.java_project.employee_management_system.entity.Department;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setJobTitle(employee.getJobTitle());
        if (employee.getDepartment() != null) {
            dto.setDepartmentId(employee.getDepartment().getId());
            dto.setDepartmentName(employee.getDepartment().getDepartmentName());
        }
        return dto;
    }

    public static Employee mapToEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId()); // Usually null for creation
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setJobTitle(dto.getJobTitle());
        return employee;
    }
}