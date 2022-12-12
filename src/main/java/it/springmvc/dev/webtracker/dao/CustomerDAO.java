package it.springmvc.dev.webtracker.dao;

import it.springmvc.dev.webtracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
