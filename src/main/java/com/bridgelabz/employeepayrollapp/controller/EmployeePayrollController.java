package com.bridgelabz.employeepayrollapp.controller;

/*
 * EmployeePayrollController.java - Section 1 UC2
 *
 * REST Controller for the Employee Payroll Application.
 * Demonstrates all HTTP methods - GET, POST, PUT and DELETE.
 * MySQL datasource properties are configured in application.properties.
 * At this stage, data is returned inline to establish REST connectivity
 * and verify data is correctly transmitted in each call.
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

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
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
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // UC1: Health-check GET - confirms the Spring App is up and serving requests
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollServiceStatus() {
        ResponseDTO responseDTO = new ResponseDTO(
            "Employee Payroll Spring App is up and running!", "Service OK");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: GET by ID - retrieves employee payroll data for the given employee ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(
            "Get Employee Payroll for empId: " + id, "Employee Data for ID " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: POST - creates a new employee payroll record using data from the JSON request body
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroll(@RequestBody Map<String, Object> body) {
        ResponseDTO responseDTO = new ResponseDTO(
            "Created Employee Payroll Data successfully!",
            "Name: " + body.get("name") + ", Salary: " + body.get("salary"));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // UC2: PUT - updates an existing employee payroll record by ID using JSON request body
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(
            @PathVariable long id, @RequestBody Map<String, Object> body) {
        ResponseDTO responseDTO = new ResponseDTO(
            "Updated Employee Payroll Data for empId: " + id,
            "Name: " + body.get("name") + ", Salary: " + body.get("salary"));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2: DELETE - removes the employee payroll record for the given ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(
            "Deleted Employee Payroll Data for empId: " + id, "Delete Successful");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
