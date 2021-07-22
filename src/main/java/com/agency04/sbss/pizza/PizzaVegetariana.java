package com.agency04.sbss.pizza;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class PizzaVegetariana implements Pizza {

    private String _name = "Vegetariana";
    private Set<Ingredients> _ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
            Ingredients.VARIOUS_VEGETABLES);

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return _ingredients;
    }
}
