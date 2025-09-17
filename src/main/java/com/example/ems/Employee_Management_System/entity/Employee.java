package com.example.ems.Employee_Management_System.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

