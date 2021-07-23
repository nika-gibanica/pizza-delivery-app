package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaOneService implements PizzeriaService {

    @Value("${pizzeriaOne.name}")
    private String name;
    @Value("${pizzeriaOne.address}")
    private String address;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getAddress(){
        return address;
    }

    @Override
    public String makePizza(Pizza pizzaType){
        return "Making " + pizzaType;
    }
}
