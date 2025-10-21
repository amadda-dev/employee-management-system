package com.java_project.employee_management_system.service.implementation;

import com.java_project.employee_management_system.dto.EmployeeDto;
import com.java_project.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplementationTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImplementation employeeService;

    private EmployeeDto employee;


    @BeforeEach
    void setUp() {
        employee = new EmployeeDto();
        employee.setId(1L);
        employee.setFirstName("Test");
        employee.setLastName("User");
        employee.setEmail("testUser@example.com");
    }
    @DisplayName("Employee Test")
    @Test
    void testCreateEmployee_ShouldReturnSavedEmployee() {
        when(employeeRepository.save(any(EmployeeDto.class))).thenReturn(employee);

        EmployeeDto savedEmployee = employeeService.createEmployee(employee);

        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals("Test", savedEmployee.getFirstName());
    }

}
