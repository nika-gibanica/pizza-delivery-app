package com.agency04.sbss.pizza.form;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryOrderForm {

    private Customer customer;
    private List<PizzaOrder> order;

    public DeliveryOrderForm(){
    }

    public DeliveryOrderForm(Customer customer, List<PizzaOrder> order) {
        this.customer = customer;
        this.order = order;
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
}
