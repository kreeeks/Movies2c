package com.movies2c.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Quiz {
    private String id;
    private String title;
    private String  description;
    private String questions;
    private String answers;
}
