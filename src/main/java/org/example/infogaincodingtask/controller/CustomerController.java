package org.example.infogaincodingtask.controller;

import org.example.infogaincodingtask.domain.Customer;
import org.example.infogaincodingtask.domain.PointsResponse;
import org.example.infogaincodingtask.service.CustomerService;
import org.example.infogaincodingtask.service.TransactionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    private TransactionService transactionService;

    public CustomerController(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping()
    public String saveCustomer(@RequestBody Customer customer) {
        return "ok";
    }

    @PutMapping()
    public String updateCustomer(@RequestBody Customer customer) {
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return "ok";
    }

    @GetMapping("/points/{id}")
    public PointsResponse getCustomerPoints(@PathVariable Long id) {
        return transactionService.getCustomerPoints(id);
    }
}
