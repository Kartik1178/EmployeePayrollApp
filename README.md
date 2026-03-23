# Employee Payroll App - BridgeLabz Spring Boot Assignment

A Spring Boot REST API for the Employee Payroll Application.

## Author
Kartikeya

## Section 1: Employee Payroll App Setup
| Branch | Description |
|--------|-------------|
| UC1-employee-payroll-setup | Spring Boot project setup with all dependencies and base REST controller |
| UC2-rest-controller | REST Controller with GET, POST, PUT, DELETE and MySQL properties |

## Section 2: DTO, Model and Service Layer
| Branch | Description |
|--------|-------------|
| UC1-dto-and-model | Introduce EmployeePayrollDTO and EmployeePayroll Model |
| UC2-service-layer | Introduce Service Layer with @Autowired Dependency Injection |
| UC3-service-store-data | Service Layer stores data in-memory as a List |

## Dependencies
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver
- Validation

## Run
mvn spring-boot:run

## CURL Commands
curl localhost:8080/employeepayrollservice/ -w "\n"
curl localhost:8080/employeepayrollservice/get/1 -w "\n"
curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Lisa\",\"salary\":2000}" "http://localhost:8080/employeepayrollservice/create" -w "\n"
curl -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Lisa\",\"salary\":2000}" "http://localhost:8080/employeepayrollservice/update/1" -w "\n"
curl -X DELETE localhost:8080/employeepayrollservice/delete/1 -w "\n"
