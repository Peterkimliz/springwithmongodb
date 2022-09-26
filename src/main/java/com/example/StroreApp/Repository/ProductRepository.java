package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends MongoRepository<Product ,String>{
    @Query(value = "{deleted:?1}")
    List<Product>findBySeller(String id,boolean deleted);
}
