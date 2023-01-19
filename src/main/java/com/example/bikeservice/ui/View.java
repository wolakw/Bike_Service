package com.example.bikeservice.ui;

import com.example.bikeservice.backend.Client;
import com.example.bikeservice.backend.ClientService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("view")
@AnonymousAllowed
public class View extends VerticalLayout {

    public View(ClientService service) {
        var crud = new GridCrud<>(Client.class, service);
        crud.getGrid().setColumns("firstName", "lastName", "mail");
        crud.getCrudFormFactory().setVisibleProperties("firstName", "lastName", "mail");

        add(
                new H1("Main view"),
                crud
        );
    }
}
