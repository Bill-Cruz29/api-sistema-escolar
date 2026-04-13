package com.Jdtecnology.api_sistema_escolar.theproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar testes de POST/PUT
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Libera todas as rotas que começam com /api/
                .anyRequest().authenticated()           // O resto continua exigindo login
            )
            .formLogin(form -> form.permitAll()); // Mantém o formulário disponível se precisar
            
        return http.build();
    }
}