package com.todoriak.securityddd.auth;


/*
    @author danatodoriak
    @project security-ddd
    @class AuthenticationRequest
    @version 1.0.0
    @since 02.05.2025 - 11.45
*/

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @Email(message = "Email is not well formatted")
    @NotEmpty(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    private String password;
}
