package com.todoriak.securityddd.catHotel;


/*
    @author danatodoriak
    @project security-ddd
    @class CatHotelService
    @version 1.0.0
    @since 31.03.2025 - 15.38
*/

import com.todoriak.securityddd.review.Review;
import com.todoriak.securityddd.staffMember.Role;
import com.todoriak.securityddd.staffMember.StaffMember;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatHotelService {

    private final CatHotelRepository repository;

    private List<CatHotel> catHotels;

    @PostConstruct
    void init() {
        List<String> amenities = List.of("Climbing trees", "Luxury beds", "Gourmet food");
        StaffMember member = new StaffMember("1", "Emily", Role.CARETAKER);
        Review review = new Review("1", "Alice", 5, "My cat loved it!");
        Review review2 = new Review("2", "Bob", 4, "Good service but a bit expensive.");
        catHotels.add(new CatHotel("1", "Cozy Paws Hotel", "123 Main Street, Cat City", 20, 5, 25, amenities, List.of(member), List.of(review)));
        catHotels.add(new CatHotel("2", "Royal Cat Resort", "456 Luxury Lane, Meowtown", 50, 40, 30, amenities, List.of(member), List.of(review2)));
        repository.saveAll(catHotels);
    }

    public List<CatHotel> getAll() {
        return repository.findAll();
    }

    public CatHotel getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public CatHotel create(CatHotel catHotel) {
        return repository.save(catHotel);
    }

    public CatHotel update(CatHotel catHotel) {
        return repository.save(catHotel);
    }
}
