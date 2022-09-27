package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart,String>{
    @Query(value = "{'customer.id':?0}")
    List<Cart>findByCustomerOrderByCreatedAt(String id);

}
