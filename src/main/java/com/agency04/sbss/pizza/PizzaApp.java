package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PizzaDeliveryService deliveryServiceFirst = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        Pizza pizzaToOrder = new PizzaMargherita();

        System.out.println(deliveryServiceFirst.orderPizza(pizzaToOrder));

        PizzeriaService pizzeriaOne = context.getBean("pizzeriaOneService", PizzeriaService.class);

        System.out.println(pizzeriaOne.getName());
        System.out.println(pizzeriaOne.getAddress());

        PizzeriaService pizzeriaTwo = context.getBean("pizzeriaTwoService", PizzeriaService.class);

        System.out.println(pizzeriaTwo.getName());
        System.out.println(pizzeriaTwo.getAddress());

        context.close();
    }

}
