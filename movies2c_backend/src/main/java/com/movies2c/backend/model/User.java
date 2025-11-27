package com.movies2c.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.lang.annotation.Documented;
import java.time.LocalDate;

@Document("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String id;
    private String userName;
    private String email;
    private String passwordHash;
    private LocalDate date;

}
