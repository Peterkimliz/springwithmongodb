package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShopRepository extends MongoRepository<Shop,String> {
  @Query("{'seller.id':?0}")
  List<Shop> findBySeller(String sellerId);
}
