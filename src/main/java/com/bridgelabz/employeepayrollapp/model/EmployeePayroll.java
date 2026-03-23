package com.bridgelabz.employeepayrollapp.model;

/*
 * EmployeePayroll.java
 *
 * Model class representing the Employee Payroll entity.
 * This is the core domain object of the application that holds
 * employee payroll data. Kept simplistic with id, name and salary
 * as the layers are still being set up. Will evolve into a full
 * JPA entity for database persistence in subsequent use cases.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

public class EmployeePayroll {

    // Unique identifier for the employee payroll record
    private long empId;

    // Name of the employee
    private String name;

    // Salary of the employee
    private double salary;

    // Default no-args constructor
    public EmployeePayroll() {
    }

    // Parameterised constructor to create an EmployeePayroll with all fields
    public EmployeePayroll(long empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Returns the unique ID of the employee
    public long getEmpId() {
        return empId;
    }

    // Sets the unique ID of the employee
    public void setEmpId(long empId) {
        this.empId = empId;
    }

    // Returns the name of the employee
    public String getName() {
        return name;
    }

    // Sets the name of the employee
    public void setName(String name) {
        this.name = name;
    }

    // Returns the salary of the employee
    public double getSalary() {
        return salary;
    }

    // Sets the salary of the employee
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
