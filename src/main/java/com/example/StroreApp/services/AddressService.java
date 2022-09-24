package com.example.StroreApp.services;

import com.example.StroreApp.DTO.AddressDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Repository.AddressRepository;
import com.example.StroreApp.models.Address;
import com.example.StroreApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public Address createAddress(AddressDto addressDto,Customer customer) {
            Address address = new Address();
            address.setCreatedAt(new Date(System.currentTimeMillis()));
            address.setUpdatedAt(new Date(System.currentTimeMillis()));
            address.setCity(addressDto.getCity());
            address.setCountry(addressDto.getCountry());
            address.setPhone(addressDto.getPhone());
            address.setStreet(addressDto.getStreet());
            address.setUserid(customer);
            return addressRepository.save(address);

    }

    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        if (addresses.size() == 0) {
            return new ArrayList<>();
        } else {
            return addresses;
        }
    }
    public List<Address> getAddressByCustomerId(String userid) {

        List<Address> addresses = addressRepository.findByUserid(userid);

        if (addresses.size() == 0) {
            return new ArrayList<>();
        } else {
            return addresses;
        }
    }

    public Address getAddressById(String id) {
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()) {
            throw new NotFoundResource("Address with id doesnot exist");
        } else {
            return address.get();
        }
    }

    public void deleteAddress(String id) {
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()) {
            throw new NotFoundResource("address with id doesnot exist");
        } else {
            addressRepository.deleteById(id);
        }
    }

    public Address updateAddress(String id,Address address) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if (!foundAddress.isPresent()) {
            throw new NotFoundResource("Address with id doesnot exist");
        } else {
            Address savedAddress = foundAddress.get();
            savedAddress.setUpdatedAt(new Date(System.currentTimeMillis()));
            savedAddress.setCountry(  address.getCountry()==null? savedAddress.getCountry() : address.getCountry());
            savedAddress.setCity(  address.getCity()==null? savedAddress.getCity() : address.getCity());
            System.out.println(address.getCity());
            savedAddress.setStreet(  address.getStreet()==null? savedAddress.getStreet() : address.getStreet());
            savedAddress.setPhone(  address.getPhone()==null? savedAddress.getPhone() : address.getPhone());
           return addressRepository.save(savedAddress);
        }
    }
}
