package com.example.bikeservice.backend.service;

import com.example.bikeservice.backend.entity.User;
import com.example.bikeservice.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService implements CrudListener<User> {

    private final UserRepository repository;

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(User client) { return repository.save(client); }

    @Override
    public User update(User client) {
        return repository.save(client);
    }

    @Override
    public void delete(User client) {
        repository.delete(client);
    }


}
