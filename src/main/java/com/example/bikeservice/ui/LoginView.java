package com.example.bikeservice.ui;

import com.example.bikeservice.backend.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "login")
@PageTitle("Login")
public class LoginView extends VerticalLayout {

    public LoginView(AuthService authService) {
        setId("login-view");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login", event ->{
                    try {
                        authService.authenticate(username.getValue(), password.getValue());
                        UI.getCurrent().navigate("view");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Wrong data");
                    }
                })
        );
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();
    }

}
