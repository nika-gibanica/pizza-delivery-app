package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PizzaDeliveryService deliveryServiceFirst = context.getBean("pizzaDeliveryServiceOne", PizzaDeliveryService.class);
        PizzaDeliveryService deliveryServiceSecond = context.getBean("pizzaDeliveryServiceTwo", PizzaDeliveryService.class);
        Pizza pizzaToOrder = context.getBean("pizzaToOrder", Pizza.class);

        System.out.println(deliveryServiceFirst.orderPizza(pizzaToOrder));
        System.out.println(deliveryServiceSecond.orderPizza(pizzaToOrder));

        PizzeriaService pizzeriaOne = context.getBean("pizzeriaServiceOne", PizzeriaService.class);

        System.out.println(pizzeriaOne.getName());
        System.out.println(pizzeriaOne.getAddress());

        PizzeriaService pizzeriaTwo = context.getBean("pizzeriaServiceTwo", PizzeriaService.class);

        System.out.println(pizzeriaTwo.getName());
        System.out.println(pizzeriaTwo.getAddress());

        context.close();
    }

}
