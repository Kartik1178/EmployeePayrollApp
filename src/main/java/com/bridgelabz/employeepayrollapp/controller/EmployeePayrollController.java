package com.bridgelabz.employeepayrollapp.controller;

/*
 * EmployeePayrollController.java - Section 2 UC2
 *
 * REST Controller for the Employee Payroll Application.
 * The Service Layer is now introduced and injected via @Autowired.
 * The Controller delegates all business logic to the Service Layer
 * and no longer creates Model objects directly - that is the job
 * of the Service Layer as per proper layered architecture.
 *
 * Base URL : http://localhost:8080/employeepayrollservice
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Service layer injected via @Autowired for Dependency Injection
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // UC2: GET all - returns service status confirming Service Layer is wired
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollServiceStatus() {
        ResponseDTO responseDTO = new ResponseDTO(
            "Employee Payroll Spring App is up - Service Layer introduced!", "Service OK");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: GET by ID - delegates to Service Layer to retrieve employee payroll by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable long id) {
        EmployeePayroll employeePayroll = employeePayrollService.getEmployeePayrollById(id);
        ResponseDTO responseDTO = new ResponseDTO(
            "Get Employee Payroll for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: POST - delegates to Service Layer to create a new employee payroll record
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroll(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = employeePayrollService.createEmployeePayroll(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
            "Created Employee Payroll Data successfully!", employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // UC2: PUT - delegates to Service Layer to update an existing employee payroll record
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(
            @PathVariable long id, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = employeePayrollService.updateEmployeePayroll(id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
            "Updated Employee Payroll Data for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: DELETE - delegates to Service Layer to delete the employee payroll record
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable long id) {
        employeePayrollService.deleteEmployeePayroll(id);
        ResponseDTO responseDTO = new ResponseDTO(
            "Deleted Employee Payroll Data for empId: " + id, "Delete Successful");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
