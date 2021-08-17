package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.PizzaApp;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PizzaController {

    private PizzaDeliveryService deliveryService;
    private Map<String, Customer> customers;
    private List<DeliveryOrderForm> submittedOrders;

    @PostConstruct
    public void loadData() {
        customers = new HashMap<>();
        submittedOrders = new ArrayList<>();

        customers.put("pizzaLover", new Customer("pizzaLover", "Mary", "Gibbs", "mary.gibbs@gmail.com", "45 Oregano Street, Rome, Italy"));
    }

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeriaInfo(){
        deliveryService = PizzaApp.getApplicationContext().getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        return deliveryService.getPizzeriaService();
    }

    @GetMapping("/pizzeria/menu")
    public List<MenuItem> getPizzeriaMenu(){
        deliveryService = PizzaApp.getApplicationContext().getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        return deliveryService.getPizzeriaService().getMenu();
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username){
        if (customers.get(username) == null) {
            throw new PizzaNotFoundException("Customer with username " + username + " not found.");
        }

        return customers.get(username);
    }

    @PostMapping("/customer")
    public ResponseEntity registerCustomer(@RequestBody Customer registrationForm) {
        customers.put(registrationForm.getUsername(), registrationForm);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customers.put(customer.getUsername(), customer);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        if (customers.get(username) == null) {
            throw new PizzaNotFoundException("Customer with username " + username + " not found.");
        }

        customers.remove(username);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delivery/order")
    public ResponseEntity orderDelivery(@RequestBody DeliveryOrderForm order) {
        deliveryService = PizzaApp.getApplicationContext().getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        boolean onTheMenu;

        for (PizzaOrder o : order.getOrder()) {
            onTheMenu = false;
            for (MenuItem i : deliveryService.getPizzeriaService().getMenu()) {
                if (o.getPizzaType().equals(i)) {
                    onTheMenu = true;
                }
            }
            if (!onTheMenu) {
                throw new PizzaNotFoundException("Pizza " + o.getPizzaType().getSize().toString().toLowerCase() + " " + o.getPizzaType().getItem() + " with a price " + o.getPizzaType().getPrice() + " NOT FOUND on the menu.");
            }
        }

        submittedOrders.add(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<DeliveryOrderForm> listOrders() {
        return submittedOrders;
    }
}
