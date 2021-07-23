package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryService {

    @Autowired
    @Qualifier("pizzeriaOne")
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){ }

    /*@Autowired
    public PizzaDeliveryService(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }*/

    /*@Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }*/

    public String orderPizza(Pizza pizza_type){
        return "Pizza " + pizza_type.getName() + " is ordered from " + pizzeriaService.getName();
    }
}
