package com.java_project.employee_management_system.service;

import com.java_project.employee_management_system.dto.EmployeeDto;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employee);

    List<EmployeeDto> getAllEmployees();

    Optional<EmployeeDto> getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDetailsDto);

    void deleteEmployee(Long id);
}
