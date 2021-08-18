package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

import java.util.List;

public interface PizzeriaService {

    String getName();
    String getAddress();
    String makePizza(Pizza pizzaType);
    List<Pizza> getMenu();
    void setMenu(List<Pizza> menu);

}
