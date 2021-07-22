package com.agency04.sbss.pizza;

import java.util.EnumSet;
import java.util.Set;

public class PizzaCapricciosa implements Pizza {

    private String _name = "Capricciosa";
    private Set<Ingredients> _ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.ARTICHOKES,
            Ingredients.MUSHROOMS, Ingredients.OLIVES, Ingredients.HAM);

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return _ingredients;
    }
}
