package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;
    private List<Delivery> submittedOrders = new ArrayList<>();

    public PizzaDeliveryService(){ }

    @Autowired
    public PizzaDeliveryService(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public String orderPizza(Delivery order){
        submittedOrders.add(order);

        return order.getOrder() + " is ordered from " + pizzeriaService.getName();
    }

    public List<Delivery> getSubmittedOrders() {
        return submittedOrders;
    }



}
