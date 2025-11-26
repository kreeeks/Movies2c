package com.movies2c.ui.components;

import com.movies2c.ui.models.Movie;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.H3;

public class MovieCards extends VerticalLayout {

    // Constructor που δέχεται Movie αντικείμενο
    public MovieCards(Movie movie) {
        this(movie.getTitle(), movie.getPosterUrl(), movie.getOverview());
    }

    // Βασικός constructor
    public MovieCards(String title, String posterUrl, String overview) {

        setWidth("250px");
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        getStyle()
                .set("background", "#111")
                .set("border-radius", "12px")
                .set("padding", "15px")
                .set("box-shadow", "0 0 12px rgba(0,0,0,0.6)");

        // Poster
        Image poster = new Image(posterUrl, title);
        poster.setWidth("200px");
        poster.getStyle()
                .set("border-radius", "10px")
                .set("margin-bottom", "10px");

        // Title
        H3 movieTitle = new H3(title);
        movieTitle.getStyle()
                .set("color", "#ffc857")
                .set("margin", "10px 0 5px 0");

        // Overview
        Paragraph desc = new Paragraph(overview);
        desc.getStyle()
                .set("color", "#ddd")
                .set("font-size", "14px")
                .set("max-width", "220px");

        add(poster, movieTitle, desc);
    }
}