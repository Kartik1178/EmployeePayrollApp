package com.bridgelabz.employeepayrollapp.service;

/*
 * IEmployeePayrollService.java
 *
 * Service interface for the Employee Payroll Application.
 * Defines the contract for all business logic operations on
 * employee payroll data including the new getAllEmployeePayroll method
 * added in UC3 to support retrieving all records from in-memory storage.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import java.util.List;

public interface IEmployeePayrollService {

    // Retrieves all employee payroll records from storage
    List<EmployeePayroll> getAllEmployeePayroll();

    // Retrieves an employee payroll record by its unique ID
    EmployeePayroll getEmployeePayrollById(long id);

    // Creates a new employee payroll record from the given DTO
    EmployeePayroll createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO);

    // Updates an existing employee payroll record by ID using data from the DTO
    EmployeePayroll updateEmployeePayroll(long id, EmployeePayrollDTO employeePayrollDTO);

    // Deletes the employee payroll record for the given ID
    void deleteEmployeePayroll(long id);
}
