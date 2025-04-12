package com.example.user_service.controller;

import com.example.user_service.dto.*;
import com.example.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.Principal;

@RestController
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate;

    public UserController(UserService userService) {
        this.userService = userService;
        this.restTemplate = new RestTemplate(); // For redirecting to admin server
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (request.getUsername().equals("admin") && request.getPassword().equals("admin123")) {
            // Redirect to admin server
            String response = restTemplate.postForObject("http://localhost:8085/admin/login", request, String.class);
            return ResponseEntity.ok("Redirected to admin service: " + response);
        }
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponse> profile(Principal principal) {
        return ResponseEntity.ok(userService.getProfile(principal.getName()));
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UpdateProfileRequest request, Principal principal) {
        return ResponseEntity.ok(userService.updateProfile(principal.getName(), request));
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request, Principal principal) {
        return ResponseEntity.ok(userService.updatePassword(principal.getName(), request));
    }
}

