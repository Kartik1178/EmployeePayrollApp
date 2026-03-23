package com.bridgelabz.employeepayrollapp.dto;

/*
 * EmployeePayrollDTO.java
 *
 * Data Transfer Object for the Employee Payroll Application.
 * Carries employee data (name and salary) from the HTTP POST and PUT
 * request body into the application. Spring automatically deserializes
 * the incoming JSON payload into this object via @RequestBody and Jackson.
 * Kept simplistic with only name and salary as the layers are still
 * being set up and will be extended to a full-fledged object later.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeePayrollDTO {

    // Name of the employee - must not be blank
    @NotBlank(message = "Employee name cannot be blank")
    public String name;

    // Salary of the employee - must be at least 1
    @NotNull(message = "Employee salary cannot be null")
    @Min(value = 1, message = "Minimum salary should be 1")
    public double salary;

    // Default no-args constructor required by Jackson for JSON deserialization
    public EmployeePayrollDTO() {
    }

    // Parameterised constructor to create a DTO with name and salary
    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
