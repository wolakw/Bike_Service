package com.example.bikeservice.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "home")
@PageTitle("Home")
public class HomeView extends VerticalLayout {

    public HomeView() {
        add (
                new H1("Welcome")
        );
    }
}
