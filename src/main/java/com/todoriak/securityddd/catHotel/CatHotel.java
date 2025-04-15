package com.todoriak.securityddd.catHotel;

/*
    @author danatodoriak
    @project security-ddd
    @class CatHotel
    @version 1.0.0
    @since 31.03.2025 - 15.25
*/

import com.todoriak.securityddd.review.Review;
import com.todoriak.securityddd.staffMember.StaffMember;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CatHotel extends AuditMetaData{
    @Id
    private String id;
    private String name;
    private String location;
    private int capacity;
    private int availableRooms;
    private double pricePerNight;
    private List<String> amenities;
    private List<StaffMember> staff;
    private List<Review> reviews;

    public CatHotel(String name, String location, int capacity, int availableRooms, double pricePerNight, List<String> amenities, List<StaffMember> staff, List<Review> reviews) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.availableRooms = availableRooms;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.staff = staff;
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CatHotel catHotel)) return false;
        return Objects.equals(getId(), catHotel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
