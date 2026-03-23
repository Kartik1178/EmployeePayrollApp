package com.bridgelabz.employeepayrollapp.controller;

/*
 * EmployeePayrollController.java - Section 2 UC3
 *
 * REST Controller for the Employee Payroll Application.
 * The Service Layer now stores, updates and deletes employee payroll
 * data in memory as a List. The Controller delegates all operations
 * to the Service Layer via @Autowired Dependency Injection.
 * Full CRUD with in-memory persistence is now working end-to-end.
 *
 * Base URL : http://localhost:8080/employeepayrollservice
 *
 * CURL Commands:
 *   GET ALL : curl localhost:8080/employeepayrollservice/ -w "\n"
 *   GET ID  : curl localhost:8080/employeepayrollservice/get/1 -w "\n"
 *   POST    : curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Lisa\",\"salary\":2000}" http://localhost:8080/employeepayrollservice/create -w "\n"
 *   PUT     : curl -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Lisa\",\"salary\":2000}" http://localhost:8080/employeepayrollservice/update/1 -w "\n"
 *   DELETE  : curl -X DELETE localhost:8080/employeepayrollservice/delete/1 -w "\n"
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
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Service layer injected via @Autowired for Dependency Injection
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // UC3: GET all - retrieves all employee payroll records from in-memory list via Service Layer
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllEmployeePayroll() {
        List<EmployeePayroll> employeePayrollList = employeePayrollService.getAllEmployeePayroll();
        ResponseDTO responseDTO = new ResponseDTO(
            "Get All Employee Payroll Data Success!", employeePayrollList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC3: GET by ID - retrieves a single employee payroll record from in-memory list by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable long id) {
        EmployeePayroll employeePayroll = employeePayrollService.getEmployeePayrollById(id);
        ResponseDTO responseDTO = new ResponseDTO(
            "Get Employee Payroll for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC3: POST - creates and stores a new employee payroll record in the in-memory list
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroll(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = employeePayrollService.createEmployeePayroll(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
            "Created Employee Payroll Data successfully!", employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // UC3: PUT - updates an existing employee payroll record in the in-memory list by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(
            @PathVariable long id, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeePayroll = employeePayrollService.updateEmployeePayroll(id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
            "Updated Employee Payroll Data for empId: " + id, employeePayroll);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC3: DELETE - removes an employee payroll record from the in-memory list by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable long id) {
        employeePayrollService.deleteEmployeePayroll(id);
        ResponseDTO responseDTO = new ResponseDTO(
            "Deleted Employee Payroll Data for empId: " + id, "Delete Successful");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
