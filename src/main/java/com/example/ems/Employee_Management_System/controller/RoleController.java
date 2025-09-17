package com.example.ems.Employee_Management_System.controller;

import com.example.ems.Employee_Management_System.entity.Role;
import com.example.ems.Employee_Management_System.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;



    @GetMapping
    public List<Role> getAll() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id); return roleService.saveRole(role);
    }

    @DeleteMapping("/{id}") public String delete(@PathVariable Long id) {
        roleService.deleteRole(id); return "Deleted Successfully!";
    }
}