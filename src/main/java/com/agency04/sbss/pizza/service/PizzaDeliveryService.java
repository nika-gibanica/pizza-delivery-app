package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;
    private List<DeliveryOrderForm> submittedOrders = new ArrayList<>();

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

    public String orderPizza(DeliveryOrderForm order){
        submittedOrders.add(order);

        return order.getOrder() + " is ordered from " + pizzeriaService.getName();
    }

    public List<DeliveryOrderForm> getSubmittedOrders() {
        return submittedOrders;
    }



}
