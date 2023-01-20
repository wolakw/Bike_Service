package com.example.bikeservice.ui.admin;

import com.example.bikeservice.backend.entity.CustomerOrder;
import com.example.bikeservice.backend.service.OrderService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = "allorder")
@PageTitle("Orders")
public class AllOrderView extends VerticalLayout {

    public AllOrderView(OrderService service) {
        var crud = new GridCrud<>(CustomerOrder.class, service);
        add(crud);
    }
}
