package com.example.bikeservice.backend.service;

import com.example.bikeservice.MainView;
import com.example.bikeservice.backend.entity.Role;
import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.repository.UserRepository;
import com.example.bikeservice.ui.View;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {
    }

    public class AuthException extends Exception {
    }

    private final UserRepository clientRepository;

    public AuthService(UserRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void authenticate(String username, String password) throws AuthException {
        User user = clientRepository.getByUsername(username);
        if (user != null && user.checkPassword(password)) {
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        ArrayList<AuthorizedRoute> routes = new ArrayList<>();

        if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("view", "View", View.class));
        } else if (role.equals(Role.EMP)) {
            routes.add(new AuthorizedRoute("view", "View", View.class));
        } else {
            routes.add(new AuthorizedRoute("view", "View", View.class));
        }
        return routes;
    }
}