package com.example.demo.service;

import com.example.demo.controller.CustomerController;
import com.example.demo.model.Customer;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class CustomerService {
    private static final ArrayList<Customer> customers = new ArrayList<>();

    {
       customers.add(new Customer("1", "Kenny", "New-York"));
       customers.add(new Customer("2", "Jessica", "Florida"));
       customers.add(new Customer("3", "Kenny", "Columbus"));
    }

    public Customer getCustomerDetail(String id){
        var result = customers.stream().filter(c -> c.getCustomerId().equals(id)).findFirst().get();
        Link a = linkTo(CustomerController.class).slash(result.getCustomerId()).withSelfRel();
        return result.add(a);
    }


}
