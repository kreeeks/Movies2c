package com.movies2c.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        //edw asxolithika me to xrwma kai me ton titlo
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        getStyle()

                .set("background-color", "#050509")
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

    }
}
