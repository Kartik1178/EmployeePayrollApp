package com.bridgelabz.employeepayrollapp.dto;

/*
 * ResponseDTO.java
 *
 * Generic Response Data Transfer Object for the Employee Payroll Application.
 * Wraps all REST API responses in a consistent JSON structure containing
 * a human-readable message and the actual response data payload.
 * Used by all controller endpoints to return uniform responses.
 *
 * Author  : Kartikeya
 * Version : 1.0
 * Since   : 2026-03-22
 */

public class ResponseDTO {

    // Human-readable message describing the result of the REST operation
    private String message;

    // The actual response data payload returned by the operation
    private Object data;

    // Default no-args constructor required by Jackson for JSON serialization
    public ResponseDTO() {
    }

    // Parameterised constructor to build a complete response with message and data
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    // Returns the response message
    public String getMessage() {
        return message;
    }

    // Sets the response message
    public void setMessage(String message) {
        this.message = message;
    }

    // Returns the response data payload
    public Object getData() {
        return data;
    }

    // Sets the response data payload
    public void setData(Object data) {
        this.data = data;
    }
}
