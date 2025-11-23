package com.movies2c.ui;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Movies2cUiApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Movies2cUiApplication.class, args);
    }
}
