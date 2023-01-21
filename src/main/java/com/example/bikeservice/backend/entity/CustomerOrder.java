package com.example.bikeservice.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CustomerOrder {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Status status;

    private String client;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="clientId",referencedColumnName="username", insertable=false, updatable=false)
//    private User client;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="employeeId",referencedColumnName="username", insertable=false, updatable=false)
//    private User employee;

    public CustomerOrder(String name, Status status, String client) {
        this.name = name;
        this.status = status;
        this.client = client;
    }

    public CustomerOrder(Long id) {
        this.id = id;
    }

//    public CustomerOrder(String name, User client) {
//        this.name = name;
//        this.client = client;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public User getClient() {
//        return client;
//    }
//
//    public void setClient(User client) {
//        this.client = client;
//    }

//    public User getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(User employee) {
//        this.employee = employee;
//    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
