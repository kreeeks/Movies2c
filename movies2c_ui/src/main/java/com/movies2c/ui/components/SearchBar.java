package com.movies2c.ui.components;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.icon.Icon;


public class SearchBar extends VerticalLayout {
    //grapse edw ton kwdika, meta kaleseton stin main view, kai telos, githubdesktop, fetch, commit, push.

    private final TextField searchField;

    public SearchBar(){
        setWidth(null);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        searchField = new TextField();
        searchField.setPlaceholder("Search Movies...");
        searchField.setWidth("450px");
        searchField.setClearButtonVisible(true);
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        //style
        searchField.getStyle()
                .set("border-radius","30px")
                .set("border","2px solid #ff7b00")
                .set("background","rgba(255, 255, 255, 0.08")
                .set("backdrop-filter","blur(4px)")
                .set("paading","10px")
                .set("color","#ffffff")
                .set("font-size","18px")
                .set("box-shadow","0 0 12px rgba(0, 0, 0, 0.4)");

        add(searchField);
    }
    public TextField getSearchField(){
        return searchField;
    }

}
