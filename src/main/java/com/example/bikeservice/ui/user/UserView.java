package com.example.bikeservice.ui.user;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "userview")
@PageTitle("User view")
public class UserView extends VerticalLayout {

    public UserView() {
        add (
                new H1("User view")
        );
    }
}
