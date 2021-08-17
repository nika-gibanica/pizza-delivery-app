package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {

    private String item;
    private PizzaSizes size;
    private int price;

    public MenuItem(){}

    public MenuItem(String item, PizzaSizes size, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(MenuItem item) {
        if (!(this.getItem().equals(item.getItem()))
                || !(this.getSize().equals(item.getSize()))
                || (this.getPrice() != item.getPrice())) {
            return false;
        }
        return true;

    }
}
