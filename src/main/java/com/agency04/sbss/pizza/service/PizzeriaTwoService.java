package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
@Primary
public class PizzeriaTwoService implements PizzeriaService {

    @Value("${pizzeriaTwo.name}")
    private String name;
    @Value("${pizzeriaTwo.address}")
    private String address;

    private List<Pizza> menu = new ArrayList<>();

    @PostConstruct
    public void doStartup(){
        menu.add(new Pizza("Margherita", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.OREGANO)));
        menu.add(new Pizza("Capricciosa", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.ARTICHOKES,
                Ingredients.MUSHROOMS, Ingredients.OLIVES, Ingredients.HAM)));
        menu.add(new Pizza("Diavola", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
                Ingredients.SPICY_SALAMI, Ingredients.CHILLI_PEPPER)));
        menu.add(new Pizza("QuattroStagioni", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
                Ingredients.MUSHROOMS, Ingredients.HAM, Ingredients.ARTICHOKES, Ingredients.OLIVES, Ingredients.OREGANO)));

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

    public List<Pizza> getMenu() {
        return menu;
    }

    public void setMenu(List<Pizza> menu) {
        this.menu = menu;
    }

    @Override
    public String makePizza(Pizza pizzaType){
        return "Making " + pizzaType;
    }

}
