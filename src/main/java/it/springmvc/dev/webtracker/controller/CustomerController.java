package it.springmvc.dev.webtracker.controller;

import it.springmvc.dev.webtracker.entity.Customer;
import it.springmvc.dev.webtracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    //need to inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        //get customer from the dao
        List<Customer> customers = customerService.getCustomers();
        // add the customers to the model
        model.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer theCustomer = new Customer();
        model.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        //save the customer using our service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
}
