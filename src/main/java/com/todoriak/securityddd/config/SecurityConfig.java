package com.todoriak.securityddd.config;


/*
    @author danatodoriak
    @project security-ddd
    @class SecurityConfig
    @version 1.0.0
    @since 04.04.2025 - 11.53
*/

import org.springframework.aop.Advisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.method.AuthorizationManagerBeforeMethodInterceptor;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    public static Advisor preAuthorizeInterceptor() {
        return AuthorizationManagerBeforeMethodInterceptor.preAuthorize();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/index.html").permitAll()
//                                .requestMatchers("/api/v1/catHotels/hello-admin").hasRole("ADMIN")
//                                .requestMatchers("/api/v1/catHotels/hello-user").hasRole("USER")
//                                .requestMatchers("/api/v1/catHotels/hello-unknown").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
//                                .requestMatchers("/api/v1/catHotels").hasRole("SUPERADMIN")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        UserDetails superAdmin = User.builder()
                .username("superAdmin")
                .password(passwordEncoder().encode("superAdmin"))
                .roles("SUPERADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin, user, superAdmin);
    }
}