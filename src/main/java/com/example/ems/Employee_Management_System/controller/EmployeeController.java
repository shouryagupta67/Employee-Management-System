package com.example.ems.Employee_Management_System.controller;

import com.example.ems.Employee_Management_System.dto.EmployeeRequest;
import com.example.ems.Employee_Management_System.entity.Department;
import com.example.ems.Employee_Management_System.entity.Employee;
import com.example.ems.Employee_Management_System.exception.DepartmentNotFoundException;
import com.example.ems.Employee_Management_System.exception.EmployeeNotFoundException;
import com.example.ems.Employee_Management_System.repository.DepartmentRepository;
import com.example.ems.Employee_Management_System.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("http://localhost:5173")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository employeeRepository,
                              DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);

        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with id:"+id));
        return ResponseEntity.ok(employee);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found!"));

        if (request.getName() != null) employee.setName(request.getName());
        if (request.getEmail() != null) employee.setEmail(request.getEmail());

        if (request.getSalary() != null) {  // <-- check for null before setting
            employee.setSalary(request.getSalary());
        }

        if (request.getDepartmentId() != null) {
            Department department = departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }

        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found!"));

        employeeRepository.delete(employee);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
