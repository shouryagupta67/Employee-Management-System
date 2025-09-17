package com.example.ems.Employee_Management_System.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String roleName; // Example: "ROLE_ADMIN" or "ROLE_USER"
}

