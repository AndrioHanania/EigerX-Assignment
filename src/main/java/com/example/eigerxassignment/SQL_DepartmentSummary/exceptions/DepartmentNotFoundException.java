package com.example.eigerxassignment.SQL_DepartmentSummary.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}