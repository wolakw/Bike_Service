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

@Route(value = "makeorderview")
@PageTitle("Make order")
public class MakeOrderView extends VerticalLayout {

    private final OrderService orderService;

    private final UserRepository userRepository;

    TextField name = new TextField("Bike name");
    TextField description = new TextField("Description");

    public MakeOrderView(OrderService service, UserRepository userRepository) {
        this.orderService = service;
        this.userRepository = userRepository;
        add (
                new H1("Place an order"),
                name,
                description,
                new Button("Order", event -> makeOrder(
                        name.getValue(),
                        description.getValue()
                ))
        );
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START);
        setSizeFull();
    }

    public void makeOrder(String name, String description) {
        if (name.isEmpty()) {
            Notification.show("Enter name");
        } else if(description.isEmpty()){
            Notification.show("Enter description");
        }else {
            User user = VaadinSession.getCurrent().getAttribute(User.class);
            orderService.newOrder(name, description, user.getUsername());
            setClear();
            Notification.show("Order placed");
        }
    }

    private void setClear() {
        name.setValue("");
        description.setValue("");
    }
}
