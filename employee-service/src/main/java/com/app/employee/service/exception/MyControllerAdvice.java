package com.app.employee.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeException e) {
        return new ResponseEntity<>("Employee not found , Please check employee first", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception){
        return new ResponseEntity<String>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
