package com.example.bikeservice.backend.service;

import com.example.bikeservice.backend.entity.CustomerOrder;
import com.example.bikeservice.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class OrderService implements CrudListener<CustomerOrder> {
    private final OrderRepository repository;


    @Override
    public Collection<CustomerOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public CustomerOrder add(CustomerOrder order) { return repository.save(order); }

    @Override
    public CustomerOrder update(CustomerOrder order) {
        return repository.save(order);
    }

    @Override
    public void delete(CustomerOrder order) {
        repository.delete(order);
    }
}
