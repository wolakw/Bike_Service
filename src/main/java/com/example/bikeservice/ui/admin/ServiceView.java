package com.example.bikeservice.ui.admin;

import com.example.bikeservice.backend.entity.Job;
import com.example.bikeservice.backend.service.JobService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = "service")
@PageTitle("Service")
public class ServiceView extends VerticalLayout {
    public ServiceView(JobService service) {
        var crud = new GridCrud<>(Job.class, service);
        crud.getCrudFormFactory().setVisibleProperties("name", "price");
        add(crud);
    }
}