package com.example.ems.Employee_Management_System.exception;

public class EmployeeNotFoundException extends RuntimeException{
  public    EmployeeNotFoundException(String message){
        super(message);
    }
}
