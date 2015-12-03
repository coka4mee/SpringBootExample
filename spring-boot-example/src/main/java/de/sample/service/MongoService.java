package de.sample.service;

import de.sample.dao.CustomerRepository;
import de.sample.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonaslanzendorfer on 03.12.15.
 */
@Service
public class MongoService {
    @Autowired
    private CustomerRepository repository;

    public void wipeAllRepositories(){
        repository.deleteAll();
    }

    public void fillCustomerRepository(){
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));
    }

    public List<String> listCustomer(){
        List<String> customers = new ArrayList<String>();
        for (Customer customer : repository.findAll()) {
            customers.add(customer.getId()+" "+customer.getFirstName()+" "+customer.getLastName());
        }
        return customers;
    }
}
