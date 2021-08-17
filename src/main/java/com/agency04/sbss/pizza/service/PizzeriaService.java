package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.model.Pizza;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface PizzeriaService {

    String getName();
    String getAddress();
    String makePizza(Pizza pizzaType);
    List<MenuItem> getMenu();
    void setMenu(List<MenuItem> menu);

}
