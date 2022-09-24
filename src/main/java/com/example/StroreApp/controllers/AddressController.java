package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.AddressDto;
import com.example.StroreApp.DTO.CustomerDto;
import com.example.StroreApp.models.Address;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.services.AddressService;
import com.example.StroreApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private CustomerService customerService;
     @Autowired
    private AddressService addressService;

    @PostMapping(path = "/{id}")
    public ResponseEntity<Address> createAddress(@PathVariable("id") String id ,@RequestBody @Validated AddressDto addressDto) {
        Customer customer=customerService.getCustomerById(id);
        Address address=addressService.createAddress(addressDto,customer);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<List<Address>>(addresses, addresses.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable("id") String id) {
        List<Address> addresses = addressService.getAddressByCustomerId(id);
        return new ResponseEntity<List<Address>>(addresses, addresses.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") String id) {
         Address address = addressService.getAddressById(id);
        return new ResponseEntity<Address>(address,  HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") String id,@RequestBody Address address) {

        return new ResponseEntity<Address>(addressService.updateAddress(id,address),  HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable("id") String id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("address deleted successfully", HttpStatus.OK);
    }

}
