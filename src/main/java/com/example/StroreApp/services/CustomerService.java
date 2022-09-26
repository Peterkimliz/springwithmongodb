package com.example.StroreApp.services;

import com.example.StroreApp.DTO.CustomerDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Exceptions.ResourceExistException;
import com.example.StroreApp.Repository.CustomerRepository;
import com.example.StroreApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Customer createCustomer(CustomerDto customerDto) {
        Optional<Customer> findcustomer = customerRepository.findByEmail(customerDto.getEmail());
        if (findcustomer.isPresent()) {
            throw new ResourceExistException("user with email address already exists");
        } else {
            Customer customer = new Customer();
            customer.setCreatedAt(new Date(System.currentTimeMillis()));
            customer.setUpdatedAt(new Date(System.currentTimeMillis()));
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setType("customer");
            customer.setPhone(customerDto.getPhone());
            customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
            return customerRepository.save(customer);

        }
    }

    public List<Customer> getCustomer() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        if (customers.size() == 0) {
            return new ArrayList<>();
        } else {
            return customers;
        }
    }

    public Customer getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new NotFoundResource("Customer with id doesnot exist");
        } else {
            return customer.get();
        }
    }

    public void deleteCustomer(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new NotFoundResource("Customer with id doesnot exist");
        } else {
            customerRepository.deleteById(id);
        }
    }

    public Customer updateCustomer(String id, Customer customer) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (!foundCustomer.isPresent()) {
            throw new NotFoundResource("Customer with email doesnot exist");
        } else {
            Customer saveCustomer = foundCustomer.get();
            saveCustomer.setUpdatedAt(new Date(System.currentTimeMillis()));
            saveCustomer.setName(customer.getName()==null? saveCustomer.getName():customer.getName());
            saveCustomer.setPhone(customer.getPhone()==null? saveCustomer.getPhone():customer.getPhone());
           return customerRepository.save(saveCustomer);
        }
    }

}
