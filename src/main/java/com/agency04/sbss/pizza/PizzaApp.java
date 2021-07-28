package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService deliveryServiceFirst = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        Pizza pizzaToOrder = new PizzaMargherita();

        System.out.println(deliveryServiceFirst.orderPizza(pizzaToOrder));

        PizzeriaService pizzeriaOne = context.getBean("pizzeriaOneService", PizzeriaService.class);
        PizzeriaService pizzeriaOneAgain = context.getBean("pizzeriaOneService", PizzeriaService.class);

        boolean resultOne = (pizzeriaOne == pizzeriaOneAgain);
        System.out.println("\nPointing to the same object: " + resultOne);
        System.out.println("Memory location for pizzeriaOne: " + pizzeriaOne);
        System.out.println("Memory location for pizzeriaOneAgain: " + pizzeriaOneAgain + "\n");

        System.out.println(pizzeriaOne.getName());
        System.out.println(pizzeriaOne.getAddress() + "\n");

        PizzeriaService pizzeriaTwo = context.getBean("pizzeriaTwoService", PizzeriaService.class);
        PizzeriaService pizzeriaTwoAgain = context.getBean("pizzeriaTwoService", PizzeriaService.class);

        boolean resultTwo = (pizzeriaTwo == pizzeriaTwoAgain);
        System.out.println("\nPointing to the same object: " + resultTwo);
        System.out.println("Memory location for pizzeriaTwo: " + pizzeriaTwo);
        System.out.println("Memory location for pizzeriaTwoAgain: " + pizzeriaTwoAgain + "\n");

        System.out.println(pizzeriaTwo.getName());
        System.out.println(pizzeriaTwo.getAddress() + "\n");

        context.close();
    }

}
