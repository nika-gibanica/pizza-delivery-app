package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
public class PizzeriaOneService implements PizzeriaService {

    @Value("${pizzeriaOne.name}")
    private String name;
    @Value("${pizzeriaOne.address}")
    private String address;

    private List<Pizza> menu = new ArrayList<>();

    @PostConstruct
    public void doStartup(){
        menu.add(new Pizza("Margherita", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.OREGANO)));
        menu.add(new Pizza("Capricciosa", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.ARTICHOKES,
                Ingredients.MUSHROOMS, Ingredients.OLIVES, Ingredients.HAM)));
        menu.add(new Pizza("Diavola", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
                Ingredients.SPICY_SALAMI, Ingredients.CHILLI_PEPPER)));
        menu.add(new Pizza("Vegetariana", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
                Ingredients.VARIOUS_VEGETABLES)));

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
    public List<Pizza> getMenu() {
        return menu;
    }

    public void setMenu(List<Pizza> menu) {
        this.menu = menu;
    }
}
