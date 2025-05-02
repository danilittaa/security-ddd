package com.todoriak.securityddd.auth;


/*
    @author danatodoriak
    @project security-ddd
    @class AuthenticationRequest
    @version 1.0.0
    @since 02.05.2025 - 11.45
*/

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationRequest {

    @NonNull
    private String login;
    @NonNull
    private String password;
}
