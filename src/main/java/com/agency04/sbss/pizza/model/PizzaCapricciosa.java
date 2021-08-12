package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaCapricciosa implements Pizza {

    private String name = "Capricciosa";
    private Set<Ingredients> ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.ARTICHOKES,
            Ingredients.MUSHROOMS, Ingredients.OLIVES, Ingredients.HAM);

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return ingredients;
    }
}
