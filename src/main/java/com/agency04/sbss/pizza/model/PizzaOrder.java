package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaOrder {

    private MenuItem pizzaType;
    private int quantity;

    public PizzaOrder(){ }

    public PizzaOrder(MenuItem pizzaType, int quantity) {
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }


    public MenuItem getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(MenuItem pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
