package com.example.ems.Employee_Management_System.controller;

import com.example.ems.Employee_Management_System.dto.LoginRequest;
import com.example.ems.Employee_Management_System.dto.RegisterRequest;
import com.example.ems.Employee_Management_System.entity.Role;
import com.example.ems.Employee_Management_System.repository.RoleRepository;
import com.example.ems.Employee_Management_System.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import com.example.ems.Employee_Management_System.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("❌ Username already exists!");
        }

        // Auto-create role if it doesn't exist
        Role role = roleRepository.findByName(request.getRoleName())
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(request.getRoleName());
                    return roleRepository.save(newRole);
                });

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return ResponseEntity.ok("✅ User registered successfully with role: " + role.getName());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
                .map(user -> {
                    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        // Login success
                        return ResponseEntity.ok(Map.of(
                                "message", "✅ Login successful",
                                "username", user.getUsername(),
                                "role", user.getRole().getName()
                        ));
                    } else {
                        // Wrong password
                        return ResponseEntity.status(401).body("❌ Invalid password");
                    }
                })
                .orElse(ResponseEntity.status(404).body("❌ User not found"));
    }
}