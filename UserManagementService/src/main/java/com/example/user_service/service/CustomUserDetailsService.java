package com.example.user_service.service;

import com.example.user_service.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final String predefinedAdminUsername = "admin";
    private final String predefinedAdminPassword = "admin123";

    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(predefinedAdminUsername)) {
            return new org.springframework.security.core.userdetails.User(
                    predefinedAdminUsername,
                    passwordEncoder.encode(predefinedAdminPassword),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }

        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                )).orElseThrow(() -> new UsernameNotFoundException("You don't have account !"));
    }
}

