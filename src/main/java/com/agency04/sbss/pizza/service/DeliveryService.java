package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository theDeliveryRepository) {
        deliveryRepository = theDeliveryRepository;
    }

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public Delivery findById(int theId) {
        Optional<Delivery> result = deliveryRepository.findById(theId);

        Delivery theDelivery = null;

        if (result.isPresent()) {
            theDelivery = result.get();
        }
        else {
            throw new RuntimeException("Did not find delivery with id " + theId);
        }

        return theDelivery;
    }

    public void save(Delivery theDelivery) {
        deliveryRepository.save(theDelivery);
    }

    public void deleteById(int theId) {
        deliveryRepository.deleteById(theId);
    }
}
