package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.rest.PizzaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository theCustomerRepository) {
        customerRepository = theCustomerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(String theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        }
        else {
            throw new PizzaNotFoundException("Customer with username " + theId + " not found.");
        }

        return theCustomer;
    }

    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    public void deleteById(String theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        if (result.isPresent()) {
            customerRepository.deleteById(theId);
        }
        else {
            throw new PizzaNotFoundException("Customer with username " + theId + " not found.");
        }
    }
}
