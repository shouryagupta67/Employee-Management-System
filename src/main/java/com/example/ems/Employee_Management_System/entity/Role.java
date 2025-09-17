package com.example.ems.Employee_Management_System.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
}