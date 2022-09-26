package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SellerRepository  extends MongoRepository<Seller,String>{
    Optional<Seller>findByEmail(String email);
}
