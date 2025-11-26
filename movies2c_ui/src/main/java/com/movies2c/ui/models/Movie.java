package com.movies2c.ui.models;

public class Movie {

    private String title;
    private String posterUrl;
    private String overview;

    public Movie(String title, String posterUrl, String overview) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getOverview() {
        return overview;
    }
}