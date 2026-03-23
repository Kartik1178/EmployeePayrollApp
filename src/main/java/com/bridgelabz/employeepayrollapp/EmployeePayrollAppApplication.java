package com.bridgelabz.employeepayrollapp;

/*
 * EmployeePayrollAppApplication.java
 *
 * Main entry point for the Employee Payroll Spring Boot Application.
 * This application serves as the backend for the Employee Payroll UI,
 * replacing the JSONServer with a full Spring Boot REST API.
 * It supports all CRUD operations on employee payroll data stored in MySQL.
 *
 * The application is structured in layers:
 *   - Controller  : Handles HTTP REST requests
 *   - Service     : Contains business logic
 *   - DTO         : Data Transfer Object for request/response
 *   - Model       : Represents the Employee Payroll entity
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollAppApplication {

    // Launches the embedded Tomcat server and starts the Spring application context
    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
    }
}
