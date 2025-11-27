package com.movies2c.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFavoriteActors {

    private  String id;
    private String userId;
    private  String actrotIds;

}
