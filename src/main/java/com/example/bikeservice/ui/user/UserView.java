package com.example.bikeservice.ui.user;

import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.repository.UserRepository;
import com.example.bikeservice.backend.service.OrderService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;

@Route(value = "userview")
@PageTitle("User view")
public class UserView extends VerticalLayout {

    private final OrderService orderService;

    private final UserRepository userRepository;

    //private User user;

    TextField name = new TextField("name");



    public UserView(OrderService service, UserRepository userRepository) {
        this.orderService = service;
        this.userRepository = userRepository;
        add (
                new H1("User view"),
                name,
                new Button("Order", event -> makeOrder(
                        name.getValue()
                ))
        );
    }

    public void makeOrder(String name) {
        if (name.isEmpty()) {
            Notification.show("Enter name");
        } else {
            User user = VaadinSession.getCurrent().getAttribute(User.class);
            orderService.newOrder(name, user.getUsername());
        }
    }
}
