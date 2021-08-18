package com.agency04.sbss.pizza.model;

import javax.persistence.*;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="pizza_id")
    private Pizza pizza;

    @Enumerated(EnumType.STRING)
    private Sizes size;

    @Column
    private int quantity;

    public PizzaOrder(){ }

    public PizzaOrder(Pizza pizza, Sizes size, int quantity) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
