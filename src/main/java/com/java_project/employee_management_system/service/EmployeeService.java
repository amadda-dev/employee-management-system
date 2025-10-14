package com.java_project.employee_management_system.service;

import com.java_project.employee_management_system.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployee(Long id);
}
