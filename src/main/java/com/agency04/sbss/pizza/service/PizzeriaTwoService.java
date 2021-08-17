package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Primary
public class PizzeriaTwoService implements PizzeriaService {

    @Value("${pizzeriaTwo.name}")
    private String name;
    @Value("${pizzeriaTwo.address}")
    private String address;

    private List<MenuItem> menu = new ArrayList<>();

    @PostConstruct
    public void doStartup(){
        menu.add(new MenuItem(new PizzaMargherita().getName(), PizzaSizes.SMALL, 22));
        menu.add(new MenuItem(new PizzaMargherita().getName(), PizzaSizes.LARGE, 25));
        menu.add(new MenuItem(new PizzaCapricciosa().getName(), PizzaSizes.LARGE, 27));
        menu.add(new MenuItem(new PizzaDiavola().getName(), PizzaSizes.LARGE, 30));
        menu.add(new MenuItem(new PizzaQuattroStagioni().getName(),  PizzaSizes.SMALL, 30));

        System.out.println("-- PostConstruct PizzeriaTwoService method --");
    }

    @PreDestroy
    public void doCleanup(){
        System.out.println("-- PreDestroy PizzeriaTwoService method --");
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getAddress(){
        return address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public String makePizza(Pizza pizzaType){
        return "Making " + pizzaType;
    }

}
