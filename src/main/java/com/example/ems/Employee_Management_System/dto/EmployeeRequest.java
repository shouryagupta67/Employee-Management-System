package com.example.ems.Employee_Management_System.dto;



public class EmployeeRequest {

    private String name;
    private String email;
    private Double salary;
    private Long departmentId;

    // Constructors
    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String email, Double salary, Long departmentId) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}

