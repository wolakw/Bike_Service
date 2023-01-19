package com.example.bikeservice.backend.service;

import com.example.bikeservice.MainView;
import com.example.bikeservice.backend.entity.Role;
import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.repository.UserRepository;
import com.example.bikeservice.ui.LogoutView;
import com.example.bikeservice.ui.View;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {
    }

    public class AuthException extends Exception {
    }

    private final UserRepository userRepository;

    public AuthService(UserRepository clientRepository) {
        this.userRepository = clientRepository;
    }

    public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.getByUsername(username);
        if (user != null && user.checkPassword(password)) {
            VaadinSession.getCurrent().setAttribute(User.class, user);
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
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        } else if (role.equals(Role.EMP)) {
            routes.add(new AuthorizedRoute("view", "View", View.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        } else {
            routes.add(new AuthorizedRoute("view", "View", View.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }
        return routes;
    }

    public void register(String username, String password) {
        userRepository.save(new User(username, password, Role.USER));
    }
}