package com.agency04.sbss.pizza;

public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){ }

    public PizzaDeliveryService(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public String orderPizza(Pizza pizza_type){
        return "Pizza " + pizza_type.getName() + " is ordered from " + pizzeriaService.getName();
    }
}
