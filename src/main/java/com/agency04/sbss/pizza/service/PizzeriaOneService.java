package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzeriaOneService implements PizzeriaService {

    @Value("${pizzeriaOne.name}")
    private String name;
    @Value("${pizzeriaOne.address}")
    private String address;

    private List<MenuItem> menu = new ArrayList<>();

    @PostConstruct
    public void doStartup(){
        menu.add(new MenuItem(new PizzaMargherita().getName(), PizzaSizes.LARGE, 25));
        menu.add(new MenuItem(new PizzaCapricciosa().getName(), PizzaSizes.LARGE, 27));
        menu.add(new MenuItem(new PizzaDiavola().getName(), PizzaSizes.LARGE, 30));
        menu.add(new MenuItem(new PizzaVegetariana().getName(), PizzaSizes.LARGE, 28));

        System.out.println("-- PostConstruct PizzeriaOneService method --");
    }

    @PreDestroy
    public void doCleanup(){
        System.out.println("-- PreDestroy PizzeriaOneService method --");
    }

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

    @Override
    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
