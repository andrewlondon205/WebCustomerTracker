package it.springmvc.dev.webtracker.controller;

import it.springmvc.dev.webtracker.dao.CustomerDAO;
import it.springmvc.dev.webtracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    //need to inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        //get customer from the dao
        List<Customer> customers = customerDAO.getCustomers();
        // add the customers to the model
        model.addAttribute("customers",customers);

        return "list-customers";
    }

}
