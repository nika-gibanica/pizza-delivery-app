package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {

    private String item;
    private PizzaSizes size;
    private float price;

    public MenuItem(){}

    public MenuItem(String item, PizzaSizes size, float price) {
        this.item = item;
        this.size = size;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public PizzaSizes getSize() {
        return size;
    }

    public void setSize(PizzaSizes size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
