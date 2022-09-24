package com.example.StroreApp.Repository;

import com.example.StroreApp.models.Address;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<Address,String> {

@Query(value = "{'userid.id':?0}")
    List<Address> findByUserid(String userid );


}
