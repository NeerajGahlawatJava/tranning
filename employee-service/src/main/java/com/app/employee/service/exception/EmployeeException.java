package com.app.employee.service.exception;

import com.app.employee.service.entity.Employee;

public class EmployeeException extends RuntimeException{

    public String message;

    public EmployeeException(String message){
        super(message);
        this.message = message;
    }
}
