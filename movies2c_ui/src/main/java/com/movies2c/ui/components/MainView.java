package com.movies2c.ui.components;
import com.movies2c.ui.services.MovieSearchBarService;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import org.springframework.beans.factory.annotation.Autowired;


@Route("")
public class MainView extends VerticalLayout {
    @Autowired
    private MovieSearchBarService movieSearchBarService;

    public MainView() {
        //edw asxolithika me to xrwma kai me ton titlo
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        getStyle()
                .set("background", "linear-gradient(90deg, #000000 0%, #0b0b0b 55%, #3a0e0e 75%, #7a1e1e 100%)")
                .set("color","#f5f5ff")
                .set("font-family", "system-ui");
        H1 title = new H1("Movies2c");
        title.getStyle()
                .set("color", "#ffc857")
                .set("margin-top", "20px")
                .set("font-size", "40px")
                .set("letter-spacing", "0.12em")
                .set("text-transform", "uppercase");
        add(title);

        //εισαγωγη και καθορισμος θεσης του search bar
        SearchBar searchBar = new SearchBar();
        searchBar.getStyle().set("margin-top","260px");
        add(title,searchBar);
        // λειτουργικότητα search bar
        searchBar.getSearchField().addValueChangeListener(event -> {
            String text = event.getValue();
            if (text == null || text.isEmpty()) {
                return;
            }
            String json = movieSearchBarService.searchMovies(text);
            add(new Html("<pre style='color:white;'>" + json + "</pre>"));
        });

    }
}
