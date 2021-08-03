package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaApp {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        SpringApplication.run(PizzaApp.class, args);

        PizzaDeliveryService deliveryServiceFirst = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        Pizza pizzaToOrder = new PizzaMargherita();

        System.out.println(deliveryServiceFirst.orderPizza(pizzaToOrder));
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

}
