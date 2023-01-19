package com.example.bikeservice.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ClientService implements CrudListener<Client> {

    private final ClientRepository repository;

    @Override
    public Collection<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client add(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        return repository.save(client);
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }
}
