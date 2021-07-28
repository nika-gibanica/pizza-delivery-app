package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Primary
@Scope("prototype")
public class PizzeriaTwoService implements PizzeriaService {

    @Value("${pizzeriaTwo.name}")
    private String name;
    @Value("${pizzeriaTwo.address}")
    private String address;

    @PostConstruct
    public void doStartup(){
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

    @Override
    public String makePizza(Pizza pizzaType){
        return "Making " + pizzaType;
    }

}
