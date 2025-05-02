package com.todoriak.securityddd.user;


/*
    @author danatodoriak
    @project security-ddd
    @class UserRepository
    @version 1.0.0
    @since 02.05.2025 - 17.55
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}