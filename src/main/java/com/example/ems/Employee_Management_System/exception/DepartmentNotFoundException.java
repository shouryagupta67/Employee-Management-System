package com.example.ems.Employee_Management_System.exception;


public class DepartmentNotFoundException extends RuntimeException{
   public DepartmentNotFoundException(String message){
        super(message);
    }
}
