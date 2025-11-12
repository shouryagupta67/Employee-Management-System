package com.example.ems.Employee_Management_System.controller;


import com.example.ems.Employee_Management_System.entity.Department;
import com.example.ems.Employee_Management_System.exception.DepartmentNotFoundException;
import com.example.ems.Employee_Management_System.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/departments")
@CrossOrigin("http://localhost:5173")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok(department);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
         if(departments.isEmpty()){
             throw new DepartmentNotFoundException("Department not found!");
         }

        return ResponseEntity.ok(departments);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return ResponseEntity.ok(department);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,
                                                       @RequestBody Department updatedDepartment) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found!"));

        department.setName(updatedDepartment.getName());
        department.setDescription(updatedDepartment.getDescription());

        departmentRepository.save(department);
        return ResponseEntity.ok(department);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        departmentRepository.delete(department);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
