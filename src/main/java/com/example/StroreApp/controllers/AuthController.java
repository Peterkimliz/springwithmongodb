package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.CustomerDto;
import com.example.StroreApp.DTO.SellerDto;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.models.Seller;
import com.example.StroreApp.services.CustomerService;
import com.example.StroreApp.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SellerService sellerService;
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return new ResponseEntity<Customer>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }
    @PostMapping("/customer/signin")
    public ResponseEntity<Customer> loginCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return new ResponseEntity<Customer>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }


    @PostMapping("/seller")
    public ResponseEntity<Seller> createSeller(@RequestBody @Validated SellerDto sellerDto) {
        return new ResponseEntity<Seller>(sellerService.createSeller(sellerDto), HttpStatus.CREATED);
    }

    @PostMapping("/seller")
    public ResponseEntity<Seller> loginSeller(@RequestBody @Validated SellerDto sellerDto) {
        return new ResponseEntity<Seller>(sellerService.createSeller(sellerDto), HttpStatus.CREATED);
    }


}
