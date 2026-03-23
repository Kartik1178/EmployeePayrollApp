package com.bridgelabz.employeepayrollapp.service;

/*
 * EmployeePayrollService.java - UC3
 *
 * Service Layer implementation for the Employee Payroll Application.
 * In this use case the Service Layer now stores, updates and deletes
 * Employee Payroll data in memory using an ArrayList. This provides
 * full in-memory CRUD functionality before database persistence
 * is introduced in subsequent use cases using JPA and MySQL.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    // In-memory list to store employee payroll records
    private final List<EmployeePayroll> employeePayrollList = new ArrayList<>();

    // Auto-incrementing ID counter for new employee records
    private final AtomicLong idCounter = new AtomicLong(1);

    // Retrieves an EmployeePayroll record by empId from the in-memory list
    @Override
    public EmployeePayroll getEmployeePayrollById(long id) {
        return employeePayrollList.stream()
            .filter(emp -> emp.getEmpId() == id)
            .findFirst()
            .orElse(null);
    }

    // Returns all employee payroll records stored in the in-memory list
    public List<EmployeePayroll> getAllEmployeePayroll() {
        return employeePayrollList;
    }

    // Creates a new EmployeePayroll record from DTO, assigns an ID, stores it in the list
    @Override
    public EmployeePayroll createEmployeePayroll(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = new EmployeePayroll(
            idCounter.getAndIncrement(),
            employeePayrollDTO.name,
            employeePayrollDTO.salary);
        employeePayrollList.add(employeePayroll);
        return employeePayroll;
    }

    // Updates an existing EmployeePayroll record in the list by empId using DTO data
    @Override
    public EmployeePayroll updateEmployeePayroll(long id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll existing = getEmployeePayrollById(id);
        if (existing != null) {
            existing.setName(employeePayrollDTO.name);
            existing.setSalary(employeePayrollDTO.salary);
        }
        return existing;
    }

    // Removes the EmployeePayroll record with the given empId from the in-memory list
    @Override
    public void deleteEmployeePayroll(long id) {
        employeePayrollList.removeIf(emp -> emp.getEmpId() == id);
    }
}
