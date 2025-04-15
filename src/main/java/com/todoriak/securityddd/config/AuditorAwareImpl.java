package com.todoriak.securityddd.config;


/*
    @author danatodoriak
    @project security-ddd
    @class AuditorAwareImpl
    @version 1.0.0
    @since 15.04.2025 - 17.14
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}
