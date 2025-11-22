package com.movies2c.backend.controller;

import com.movies2c.backend.service.TmdbClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final TmdbClient tmdbClient;

    public MovieController(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @GetMapping("/api/movies/trending")
    public String trendingMovies() {
        return tmdbClient.getTrendingMovies();
    }
}
