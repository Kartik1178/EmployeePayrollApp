package com.bridgelabz.employeepayrollapp.service;

/*
 * EmployeePayrollService.java
 *
 * Service Layer implementation for the Employee Payroll Application.
 * This class is annotated with @Service so Spring manages it as a bean.
 * It handles all business logic for employee payroll operations and
 * is injected into the Controller via @Autowired Dependency Injection.
 * In UC2, the service creates and returns Model objects directly
 * without storing them - storage will be added in UC3.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    // Retrieves and returns an EmployeePayroll Model for the given employee ID
    @Override
    public EmployeePayroll getEmployeePayrollById(long id) {
        return new EmployeePayroll(id, "Sample Employee", 50000);
    }

    // Creates a new EmployeePayroll Model from the given DTO and returns it
    @Override
    public EmployeePayroll createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayroll(0, employeePayrollDTO.name, employeePayrollDTO.salary);
    }

    // Updates and returns an EmployeePayroll Model for the given ID using DTO data
    @Override
    public EmployeePayroll updateEmployeePayroll(long id, EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayroll(id, employeePayrollDTO.name, employeePayrollDTO.salary);
    }

    // Deletes the employee payroll record - currently a no-op placeholder
    @Override
    public void deleteEmployeePayroll(long id) {
    }
}
