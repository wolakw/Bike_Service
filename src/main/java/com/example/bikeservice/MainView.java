package com.example.bikeservice;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MainView extends AppLayout {
    public MainView() {
        createHeader();
    }

    private void createHeader() {
        H1 logo = new H1("Wolszyn | Courier system");
        logo.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);

        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }
}
