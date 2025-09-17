package com.example.ems.Employee_Management_System.service;


import com.example.ems.Employee_Management_System.entity.Role;
import com.example.ems.Employee_Management_System.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    public Role saveRole(Role role) {

        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
