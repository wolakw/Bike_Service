package com.example.bikeservice.ui.admin;

import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.service.UserService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route(value = "adminusers")
@PageTitle("Users")
public class AdminUserView extends VerticalLayout {

    public AdminUserView(UserService service) {
        var crud = new GridCrud<>(User.class);
        crud.setFindAllOperation(service::findAll);
        crud.setAddOperationVisible(false);
        crud.getGrid().setColumns("id","firstName", "lastName", "username", "role", "passwordSalt", "passwordHash");
        crud.getCrudFormFactory().setVisibleProperties("firstName", "lastName", "username", "role");
        add(
                crud
        );
    }
}
