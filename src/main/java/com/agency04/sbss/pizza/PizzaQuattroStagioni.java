package com.agency04.sbss.pizza;

import java.util.EnumSet;
import java.util.Set;

public class PizzaQuattroStagioni implements Pizza {

    private String _name = "Quattro Stagioni";
    private Set<Ingredients> _ingredients = EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA,
            Ingredients.MUSHROOMS, Ingredients.HAM, Ingredients.ARTICHOKES, Ingredients.OLIVES, Ingredients.OREGANO);

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public Set<Ingredients> getIngredients(){
        return _ingredients;
    }
}
