package com.bridgelabz.employeepayrollapp.controller;

/*
 * EmployeePayrollController.java - Section 2 UC1
 *
 * REST Controller for the Employee Payroll Application.
 * In this UC, the Controller directly creates the EmployeePayroll Model
 * from the incoming EmployeePayrollDTO and returns it as the response.
 * This demonstrates the DTO-to-Model conversion pattern before the
 * Service Layer is introduced in the next use case.
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
import jakarta.validation.Valid;
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

    // UC1: GET all - returns service status; model and DTO now introduced
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollServiceStatus() {
        ResponseDTO responseDTO = new ResponseDTO(
            "Employee Payroll Spring App is up - DTO and Model introduced!", "Service OK");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC1: GET by ID - creates and returns an EmployeePayroll Model for the given ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable long id) {
        EmployeePayroll employeePayroll = new EmployeePayroll(id, "Sample Employee", 50000);
        ResponseDTO responseDTO = new ResponseDTO(
            "Get Employee Payroll for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC1: POST - maps EmployeePayrollDTO to EmployeePayroll Model and returns the Model
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroll(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = new EmployeePayroll(
            0, employeePayrollDTO.name, employeePayrollDTO.salary);
        ResponseDTO responseDTO = new ResponseDTO(
            "Created Employee Payroll Data successfully!", employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // UC1: PUT - maps EmployeePayrollDTO to EmployeePayroll Model and returns the updated Model
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(
            @PathVariable long id, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = new EmployeePayroll(
            id, employeePayrollDTO.name, employeePayrollDTO.salary);
        ResponseDTO responseDTO = new ResponseDTO(
            "Updated Employee Payroll Data for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC1: DELETE - returns confirmation of deletion for the given employee ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(
            "Deleted Employee Payroll Data for empId: " + id, "Delete Successful");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
