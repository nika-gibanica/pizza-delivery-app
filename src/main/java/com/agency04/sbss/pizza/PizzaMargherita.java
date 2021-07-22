package com.agency04.sbss.pizza;

import java.util.EnumSet;
import java.util.Set;

public class PizzaMargherita implements Pizza {

    private String _name = "Margherita";
    private Set<Ingredients> _ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.OREGANO);

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return _ingredients;
    }
}
