package com.example.ems.Employee_Management_System.repository;

import com.example.ems.Employee_Management_System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
