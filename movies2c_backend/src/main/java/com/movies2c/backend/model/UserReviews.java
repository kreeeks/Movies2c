package com.movies2c.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserReviews {

    private String id;
    private  String movieId;
    private  String rating;
    private String comment;
}
