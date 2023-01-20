package com.example.bikeservice.ui.emp;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "orderview")
@PageTitle("Order view")
public class OrderView extends VerticalLayout {

    public OrderView() {
        add (
                new H1("Seriwsant view")
        );
    }
}
