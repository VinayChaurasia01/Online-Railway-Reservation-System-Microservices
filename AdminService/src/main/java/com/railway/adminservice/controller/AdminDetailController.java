package com.railway.adminservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminDetailController {
    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok("Welcome to Admin Dashboard!");
    }

    /*@GetMapping("/users")
    public ResponseEntity<List<String>> getAllUsers() {
        // Simulated response
        List<String> users = Arrays.asList("user1", "user2", "user3");
        return ResponseEntity.ok(users);
    }*/
}
