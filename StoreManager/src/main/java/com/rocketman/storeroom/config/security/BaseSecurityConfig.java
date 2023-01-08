package com.rocketman.storeroom.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BaseSecurityConfig {


    @Bean
    SecurityFilterChain configure(){
        return null;
    }
}
