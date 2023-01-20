package com.example.bikeservice.ui.admin;

import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.service.UserService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = "view")
@PageTitle("View")
public class AdminView extends VerticalLayout {

    public AdminView(UserService service) {
        var crud = new GridCrud<>(User.class, service);
        //crud.getGrid().setColumns("firstName", "lastName", "mail");
        //crud.getCrudFormFactory().setVisibleProperties("firstName", "lastName", "mail");

        add(
                new H1("Main view"),
                crud
        );
    }
}
