package it.springmvc.dev.webtracker.service;

import it.springmvc.dev.webtracker.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService {
    public List<Customer> getCustomers ();
    public void saveCustomer(Customer theCustomer);
}
