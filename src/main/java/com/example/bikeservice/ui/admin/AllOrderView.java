package com.example.bikeservice.ui.admin;

import com.example.bikeservice.backend.entity.CustomerOrder;
import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.service.OrderService;
import com.vaadin.flow.component.crud.CrudGrid;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route(value = "adminorder")
@PageTitle("Orders")
public class AllOrderView extends VerticalLayout {
    public AllOrderView(OrderService service) {
        var crud = new GridCrud<>(CustomerOrder.class, service);
        crud.setAddOperationVisible(false);
        crud.getGrid().setColumns("id", "name", "client", "employee", "orderDate", "pickupDate", "status");
        crud.getCrudFormFactory().setVisibleProperties("name", "client", "employee", "pickupDate", "status");
        add(crud);
    }
}