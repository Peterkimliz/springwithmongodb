package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.CustomerDto;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return new ResponseEntity<Customer>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomer();
        return new ResponseEntity<List<Customer>>(customers, customers.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("customer deleted successfully", HttpStatus.OK);
    }

}
