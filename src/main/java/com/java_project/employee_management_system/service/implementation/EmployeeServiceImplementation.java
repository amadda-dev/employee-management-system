package com.java_project.employee_management_system.service.implementation;

import com.java_project.employee_management_system.dto.EmployeeDto;
import com.java_project.employee_management_system.entity.Department;
import com.java_project.employee_management_system.entity.Employee;
import com.java_project.employee_management_system.mapper.EmployeeMapper;
import com.java_project.employee_management_system.repository.DepartmentRepository;
import com.java_project.employee_management_system.repository.EmployeeRepository;
import com.java_project.employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository; // 1. Inject Department repository

    // 2. Update constructor to inject both repositories
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // 3. Convert DTO to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // 4. Find the department by ID
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + employeeDto.getDepartmentId()));

        // 5. Set the department on the employee
        employee.setDepartment(department);

        // 6. Save the employee entity
        Employee savedEmployee = employeeRepository.save(employee);

        // 7. Convert saved entity back to DTO for the response
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::mapToEmployeeDto); // 8. Use map to convert the Optional<Employee> to Optional<EmployeeDto>
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::mapToEmployeeDto) // 9. Use stream to convert the list
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDetailsDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        // Find the new department
        Department department = departmentRepository.findById(employeeDetailsDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + employeeDetailsDto.getDepartmentId()));

        // Update fields
        existingEmployee.setFirstName(employeeDetailsDto.getFirstName());
        existingEmployee.setLastName(employeeDetailsDto.getLastName());
        existingEmployee.setEmail(employeeDetailsDto.getEmail());
        existingEmployee.setJobTitle(employeeDetailsDto.getJobTitle());
        existingEmployee.setDepartment(department); // 10. Update the department

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(existingEmployee);
    }
}



