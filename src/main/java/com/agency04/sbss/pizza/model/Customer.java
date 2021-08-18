package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="username")
    private String username;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="customerDetails_id")
    private CustomerDetails customerDetails;

    public Customer() {

    }

    public Customer(String username, CustomerDetails customerDetails) {
        this.username = username;
        this.customerDetails = customerDetails;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
