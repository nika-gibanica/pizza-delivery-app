package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.pizza.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PizzaDeliveryService deliveryServiceFirst = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        Pizza pizzaToOrder = context.getBean("pizzaMargherita", Pizza.class);

        System.out.println(deliveryServiceFirst.orderPizza(pizzaToOrder));

        PizzeriaService pizzeriaOne = context.getBean("pizzeriaOne", PizzeriaService.class);

        System.out.println(pizzeriaOne.getName());
        System.out.println(pizzeriaOne.getAddress());

        PizzeriaService pizzeriaTwo = context.getBean("pizzeriaTwo", PizzeriaService.class);

        System.out.println(pizzeriaTwo.getName());
        System.out.println(pizzeriaTwo.getAddress());

        context.close();
    }

}
