package com.todoriak.securityddd.catHotel;


/*
    @author danatodoriak
    @project security-ddd
    @class CatHotelRepository
    @version 1.0.0
    @since 31.03.2025 - 15.36
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatHotelRepository extends MongoRepository<CatHotel, String> {
}
