package com.todoriak.securityddd.catHotel;


/*
    @author danatodoriak
    @project security-ddd
    @class CatHotelRestController
    @version 1.0.0
    @since 31.03.2025 - 16.03
*/

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catHotels")
@AllArgsConstructor
public class CatHotelRestController {
    private final CatHotelService service;

    @GetMapping
    public List<CatHotel> getCatHotels() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CatHotel getCatHotel(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCatHotel(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public CatHotel createCatHotel(@RequestBody CatHotel catHotel) {
        return service.create(catHotel);
    }

    @PutMapping
    public CatHotel updateCatHotel(@RequestBody CatHotel catHotel) {
        return service.update(catHotel);
    }

    @GetMapping("/hello-user")
    @PreAuthorize("hasAuthority('USER')")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/hello-admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @GetMapping("/hello-unknown")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String helloUnknown() {
        return "Hello Unknown";
    }

    @GetMapping("/hello-stranger")
    public String helloStranger() {
        return "Hello Stranger";
    }
}
