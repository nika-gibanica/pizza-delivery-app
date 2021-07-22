package com.agency04.sbss.pizza;

import java.util.EnumSet;
import java.util.Set;

public class PizzaDiavola implements Pizza {

    private String _name = "Diavola";
    private Set<Ingredients> _ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
            Ingredients.SPICY_SALAMI, Ingredients.CHILLI_PEPPER);

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return _ingredients;
    }
}
