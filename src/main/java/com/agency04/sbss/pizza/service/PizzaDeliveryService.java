package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){ }

    @Autowired
    public PizzaDeliveryService(@Qualifier("pizzeriaOneService") PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @Autowired
    @Qualifier("pizzeriaOneService")
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public String orderPizza(Pizza pizzaType){
        return "Pizza " + pizzaType.getName() + " is ordered from " + pizzeriaService.getName();
    }
}
