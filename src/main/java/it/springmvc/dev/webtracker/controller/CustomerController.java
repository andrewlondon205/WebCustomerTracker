package it.springmvc.dev.webtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        return "list-customers";
    }

}
