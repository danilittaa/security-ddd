package com.todoriak.securityddd.auth;


/*
    @author danatodoriak
    @project security-ddd
    @class AuthenticationResponse
    @version 1.0.0
    @since 02.05.2025 - 11.48
*/

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthenticationResponse {
    public String token;
}
