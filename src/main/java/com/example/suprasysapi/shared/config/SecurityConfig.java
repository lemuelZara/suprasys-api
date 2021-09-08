package com.example.suprasysapi.shared.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_LIST = {
        "/api/v1",
        "/api/v1/clients",
        "/api/v1/clients/{id}",
        "/api/v1/products",
        "/api/v1/products/{id}",
        "/api/v1/sales",
        "/api/v1/sales/{id}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers(AUTH_LIST).permitAll()
            .anyRequest().authenticated();
    }
}
