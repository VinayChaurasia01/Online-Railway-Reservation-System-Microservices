package com.railway.traininformationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/trains/**").permitAll()
                        /*.requestMatchers("/trains/delete/**").authenticated()
                        .requestMatchers("/trains/add").authenticated()
                        .requestMatchers("/trains/all").authenticated()*/
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
