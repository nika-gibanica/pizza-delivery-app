package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzaController {

    private PizzaDeliveryService pizzaDeliveryService;
    private CustomerService customerService;
    private DeliveryService deliveryService;

    @Autowired
    public PizzaController(PizzaDeliveryService thePizzaDeliveryService, CustomerService theCustomerService, DeliveryService theDeliveryService) {
        pizzaDeliveryService = thePizzaDeliveryService;
        customerService = theCustomerService;
        deliveryService = theDeliveryService;
    }

    @PostConstruct
    public void loadData() {

        Customer customer1 = new Customer ("pizzaislife", new CustomerDetails("jane.goldberg@pizzamail.com", "Jane", "Goldberg", "0912458877"));
        Customer customer2 = new Customer("pizzaLover", new CustomerDetails("mary.gibbs@pizzamail.com", "Mary", "Gibbs", "0995284521"));
        Customer customer3 = new Customer("ilovepizza", new CustomerDetails("anthony.kent@pizzamail.com", "Anthony", "Kent", "0974545555"));
        Customer customer4 = new Customer("pizzalicious", new CustomerDetails("pizzalicious.hanna@pizzamail.com", "Hanna", "Collins", "0918557447"));

        Pizza pizzaMargherita = new Pizza("Margherita", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.OREGANO));
        Pizza pizzaDiavola = new Pizza("Diavola", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.SPICY_SALAMI, Ingredients.CHILLI_PEPPER));
        Pizza pizzaCapricciosa = new Pizza("Capricciosa", EnumSet.of(Ingredients.TOMATO_SAUCE, Ingredients.MOZZARELLA, Ingredients.ARTICHOKES, Ingredients.MUSHROOMS, Ingredients.OLIVES, Ingredients.HAM));

        PizzaOrder pizzaorder1 = new PizzaOrder(pizzaMargherita, Sizes.MEDIUM, 2);
        PizzaOrder pizzaorder2 = new PizzaOrder(pizzaDiavola, Sizes.LARGE, 1);
        PizzaOrder pizzaorder3 = new PizzaOrder(pizzaCapricciosa, Sizes.SMALL, 1);

        ArrayList<PizzaOrder> orders1 = new ArrayList<>();
        orders1.add(pizzaorder1);
        orders1.add(pizzaorder2);

        ArrayList<PizzaOrder> orders2 = new ArrayList<>();
        orders2.add(pizzaorder3);

        customerService.save(customer1);
        customerService.save(customer2);
        deliveryService.save(new Delivery(customer3, orders1, new java.util.Date()));
        deliveryService.save(new Delivery(customer4, orders2, new java.util.Date()));
    }

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeriaInfo(){
        return pizzaDeliveryService.getPizzeriaService();
    }

    @GetMapping("/pizzeria/menu")
    public List<Pizza> getPizzeriaMenu(){
        return pizzaDeliveryService.getPizzeriaService().getMenu();
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username){
        return customerService.findById(username);
    }

    @PostMapping("/customer")
    public ResponseEntity registerCustomer(@RequestBody Customer registrationForm) {
        customerService.save(registrationForm);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customerService.save(customer);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        customerService.deleteById(username);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delivery/order")
    public ResponseEntity orderDelivery(@RequestBody Delivery order) {
        boolean onTheMenu;

        for (PizzaOrder o : order.getOrder()) {
            onTheMenu = false;
            for (Pizza p : pizzaDeliveryService.getPizzeriaService().getMenu()) {
                if (o.getPizza().getName().equals(p.getName())) {
                    onTheMenu = true;
                }
            }
            if (!onTheMenu) {
                throw new PizzaNotFoundException("Pizza " + o.getPizza().getName() + " NOT FOUND on the menu.");
            }
        }

        order.setSubmissionDate(new java.util.Date());
        deliveryService.save(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<Delivery> listOrders() {
        return deliveryService.findAll();
    }
}
