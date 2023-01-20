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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId",referencedColumnName="username", insertable=false, updatable=false)
    private User client;

//    @ManyToOne
//    @JoinColumn(name="employeeId",referencedColumnName="username", insertable=false, updatable=false)
//    private User employee;

    public CustomerOrder(String name, User client) {
        this.name = name;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

//    public User getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(User employee) {
//        this.employee = employee;
//    }
}
