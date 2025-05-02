package com.todoriak.securityddd.auth;


/*
    @author danatodoriak
    @project security-ddd
    @class AuthenticationController
    @version 1.0.0
    @since 02.05.2025 - 11.49
*/

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>
        authenticate(@RequestBody AuthenticationRequest request) {
            return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
