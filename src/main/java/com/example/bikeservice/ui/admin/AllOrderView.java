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

import java.util.ArrayList;
import java.util.List;

@Route(value = "allorder")
@PageTitle("Orders")
public class AllOrderView extends VerticalLayout {
    public AllOrderView(OrderService service) {
        var crud = new GridCrud<>(CustomerOrder.class, service);
        add(crud);
    }
}