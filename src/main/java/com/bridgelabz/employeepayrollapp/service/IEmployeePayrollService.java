package com.bridgelabz.employeepayrollapp.service;

/*
 * IEmployeePayrollService.java
 *
 * Service interface for the Employee Payroll Application.
 * Defines the contract for all business logic operations on
 * employee payroll data. The Controller depends on this interface
 * rather than the concrete implementation, following the Dependency
 * Inversion Principle and enabling easier testing and extensibility.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;

public interface IEmployeePayrollService {

    // Retrieves an employee payroll record by its unique ID
    EmployeePayroll getEmployeePayrollById(long id);

    // Creates a new employee payroll record from the given DTO
    EmployeePayroll createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO);

    // Updates an existing employee payroll record by ID using data from the DTO
    EmployeePayroll updateEmployeePayroll(long id, EmployeePayrollDTO employeePayrollDTO);

    // Deletes the employee payroll record for the given ID
    void deleteEmployeePayroll(long id);
}
