package com.todoriak.securityddd.config;


/*
    @author danatodoriak
    @project security-ddd
    @class AuditionConfig
    @version 1.0.0
    @since 15.04.2025 - 17.16
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class AuditionConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
