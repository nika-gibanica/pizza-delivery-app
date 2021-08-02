package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.PizzaApp;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @GetMapping("/")
    public String orderPizzaMargherita() {
        PizzaDeliveryService deliveryServiceFirst = PizzaApp.getApplicationContext().getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        Pizza pizzaToOrder = new PizzaMargherita();

        return deliveryServiceFirst.orderPizza(pizzaToOrder);
    }

    @GetMapping("/pizzeriaOne")
    public String getPizzeriaOneInfo(){
        PizzeriaService pizzeriaOne = PizzaApp.getApplicationContext().getBean("pizzeriaOneService", PizzeriaService.class);

        return pizzeriaOne.getName() + " is at the address " + pizzeriaOne.getAddress();
    }

    @GetMapping("/pizzeriaTwo")
    public String getPizzeriaTwoInfo(){
        PizzeriaService pizzeriaTwo = PizzaApp.getApplicationContext().getBean("pizzeriaTwoService", PizzeriaService.class);

        return pizzeriaTwo.getName() + " is at the address " + pizzeriaTwo.getAddress();
    }
}
