package com.example.bikeservice.ui;

import com.example.bikeservice.backend.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("register")
public class RegisterView extends Composite {
    private final AuthService authService;

    public RegisterView(AuthService authService) {
        this.authService = authService;
    }

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    TextField username = new TextField("Username");
    PasswordField password1 = new PasswordField("Password");
    PasswordField password2 = new PasswordField("Confirm Password");


    protected Component initContent() {
        return new VerticalLayout(
                new H2("Register"),
                firstName,
                lastName,
                username,
                password1,
                password2,
                new Button("Send", event -> register(
                        firstName.getValue(),
                        lastName.getValue(),
                        username.getValue(),
                        password1.getValue(),
                        password2.getValue()
                ))
        );
    }

    private void register(String firstname, String lastname, String username, String password1, String password2) {
        if (username.trim().isEmpty()) {
            Notification.show("Enter username");
        } else if (password1.isEmpty()) {
            Notification.show("Enter password");
        } else if (!password1.equals(password2)) {
            Notification.show("Password don't match");
        } else {
            authService.register(firstname, lastname, username, password1);
            Notification.show("Registration succeeded");
        }
    }
}