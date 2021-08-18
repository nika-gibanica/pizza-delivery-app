package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> { }
