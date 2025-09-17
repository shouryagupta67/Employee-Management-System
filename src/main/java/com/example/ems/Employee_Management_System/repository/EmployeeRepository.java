package com.example.ems.Employee_Management_System.repository;

import com.example.ems.Employee_Management_System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameContaining(String name);
}
