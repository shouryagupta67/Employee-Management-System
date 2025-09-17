package com.example.ems.Employee_Management_System.exception;

import lombok.val;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEmployeeNotFound(EmployeeNotFoundException ex){
        Map<String ,Object> body = new HashMap<>();
        body.put("timeStamp", LocalDateTime.now());
        body.put("message",ex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDepartmentNotFound(DepartmentNotFoundException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timeStamp",LocalDateTime.now());
        body.put("message",ex.getMessage());
        body.put("status",HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timesStamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleGemricException(Exception ex){
        Map<String,Object>  body = new HashMap<>();
        body.put("timeStamp",LocalDateTime.now());
        body.put("message",ex.getMessage());
        body.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
