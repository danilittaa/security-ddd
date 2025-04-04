package com.todoriak.securityddd.review;


/*
    @author danatodoriak
    @project security-ddd
    @class Review
    @version 1.0.0
    @since 31.03.2025 - 15.31
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String id;
    private String author;
    private int rating;
    private String comment;
}
