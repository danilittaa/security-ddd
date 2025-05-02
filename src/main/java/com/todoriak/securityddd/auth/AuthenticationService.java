package com.todoriak.securityddd.auth;


/*
    @author danatodoriak
    @project security-ddd
    @class AuthenticationService
    @version 1.0.0
    @since 02.05.2025 - 11.49
*/

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
