package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.CustomerDto;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid  CustomerDto customerDto){
       return new ResponseEntity<Customer>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(@RequestBody @Valid  CustomerDto customerDto){
        List<Customer> customers=customerService.getCustomer();
        return new ResponseEntity<List<Customer>>(customers, customers.size()==0?HttpStatus.NOT_FOUND:HttpStatus.OK);
    }

}
