package com.java_project.employee_management_system.service;

import com.java_project.employee_management_system.entity.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(Long id);
}



