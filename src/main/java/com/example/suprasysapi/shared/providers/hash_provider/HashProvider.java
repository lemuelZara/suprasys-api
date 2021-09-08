package com.example.suprasysapi.shared.providers.hash_provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class HashProvider {
    
    @Bean
    public PasswordEncoder generateHash() {
        return new BCryptPasswordEncoder();
    }
}
