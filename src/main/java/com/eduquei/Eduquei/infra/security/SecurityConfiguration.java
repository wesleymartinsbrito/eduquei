package com.eduquei.Eduquei.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/alunos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/alunos").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.DELETE, "/alunos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/alunos").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.PUT, "/alunos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/alunos").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.POST, "/escolas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/escolas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/escolas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/aulas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/aulas").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.DELETE, "/aulas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/aulas").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.PUT, "/aulas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/profissional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/profissional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/profissional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/chamados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/chamados").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.POST, "/chamados").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/chamados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/chamados").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.GET, "/chamados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/chamados").hasRole("PROFESSIONAL")
                        .requestMatchers(HttpMethod.GET, "/chamados").hasRole("USER")
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
