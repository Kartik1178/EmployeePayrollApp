package com.bridgelabz.employeepayrollapp.controller;

/*
 * EmployeePayrollController.java - Section 1 UC1
 *
 * REST Controller for the Employee Payroll Application.
 * Created as part of the initial project setup to verify the Spring Boot
 * application starts correctly and can serve REST requests from the
 * Employee Payroll Frontend UI, replacing the JSONServer backend.
 *
 * Base URL : http://localhost:8080/employeepayrollservice
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // UC1: Health-check GET - confirms the Spring App is up and serving requests from the UI
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollServiceStatus() {
        ResponseDTO responseDTO = new ResponseDTO(
            "Employee Payroll Spring App is up and running!", "Service OK");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
