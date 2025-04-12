package com.example.user_service.service;

import com.example.user_service.dto.*;

public interface UserService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
    ProfileResponse getProfile(String username);
    String updateProfile(String username, UpdateProfileRequest request);
    String updatePassword(String username, UpdatePasswordRequest request);
}

