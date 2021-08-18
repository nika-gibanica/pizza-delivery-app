package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pizza {

    @Id
    private String name;

    @ElementCollection(targetClass=Ingredients.class)
    @JoinTable(name="tblIngredients", joinColumns=@JoinColumn(name="pizza_id"))
    @Column(name="ingredients")
    @Enumerated(EnumType.STRING)
    private Set<Ingredients> ingredients;

    public Pizza(String name, Set<Ingredients> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Pizza() {}

    public String getName(){
        return name;
    }

    public Set<Ingredients> getIngredients(){
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
