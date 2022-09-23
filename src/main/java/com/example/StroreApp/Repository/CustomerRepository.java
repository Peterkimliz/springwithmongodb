package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Optional<Customer>findByEmail(String email);
}
