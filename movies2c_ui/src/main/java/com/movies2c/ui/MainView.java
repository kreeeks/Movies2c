package com.movies2c.ui;

import com.movies2c.ui.components.MovieCards;
import com.movies2c.ui.components.SearchBar;
import com.movies2c.ui.models.Movie;
import com.movies2c.ui.services.MovieSearchBarService;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    @Autowired
    private MovieSearchBarService movieSearchBarService;

    private VerticalLayout resultsContainer = new VerticalLayout();

    public MainView() {

        // Layout ρυθμίσεις
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Background style
        getStyle()
                .set("background", "linear-gradient(90deg, #000000 0%, #0b0b0b 55%, #3a0e0e 75%, #7a1e1e 100%)")
                .set("color","#f5f5ff")
                .set("font-family", "system-ui");

        // Τίτλος
        H1 title = new H1("Movies2c");
        title.getStyle()
                .set("color", "#ffc857")
                .set("margin-top", "20px")
                .set("font-size", "40px")
                .set("letter-spacing", "0.12em")
                .set("text-transform", "uppercase");

        add(title);

        // SearchBar
        SearchBar searchBar = new SearchBar();
        searchBar.getStyle().set("margin-top","40px");
        add(searchBar);

        // *** ΕΔΩ ΘΑ ΕΜΦΑΝΙΖΟΝΤΑΙ ΟΛΕΣ ΟΙ MOVIE CARDS ***
        resultsContainer.setWidth("80%");
        resultsContainer.setPadding(false);
        resultsContainer.setSpacing(true);
        resultsContainer.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(resultsContainer);

        // Search λειτουργικότητα
        searchBar.getSearchField().addValueChangeListener(event -> {
            String text = event.getValue();

            // Αν άδειο → καθάρισε
            if (text == null || text.isEmpty()) {
                resultsContainer.removeAll();
                return;
            }

            // Καθαρισμός προηγούμενων αποτελεσμάτων
            resultsContainer.removeAll();

            // API call
            List<Movie> movies = movieSearchBarService.searchMovies(text);

            // ΕΜΦΑΝΙΣΗ MOVIE CARDS
            for (Movie movie : movies) {
                resultsContainer.add(new MovieCards(movie));
            }
        });
    }
}