package com.agency04.sbss.pizza.model.pizzeria;

import com.agency04.sbss.pizza.model.pizza.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaTwo implements PizzeriaService {

    @Value("${pizzeriaTwo.name}")
    private String _name;
    @Value("${pizzeriaTwo.address}")
    private String _address;

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public String getAddress(){
        return _address;
    }

    @Override
    public String makePizza(Pizza pizza_type){
        return "Making " + pizza_type;
    }

}
