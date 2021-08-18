package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="pizzaOrder_id")
    private List<PizzaOrder> order;

    @Column
    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    public Delivery(){
    }

    public Delivery(Customer customer, List<PizzaOrder> order, Date submissionDate) {
        this.customer = customer;
        this.order = order;
        this.submissionDate = submissionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PizzaOrder> getOrder() {
        return order;
    }

    public void setOrder(List<PizzaOrder> order) {
        this.order = order;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
}
