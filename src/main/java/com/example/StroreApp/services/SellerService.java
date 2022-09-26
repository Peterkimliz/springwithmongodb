package com.example.StroreApp.services;

import com.example.StroreApp.DTO.SellerDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Exceptions.ResourceExistException;
import com.example.StroreApp.Repository.SellerRepository;
import com.example.StroreApp.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Seller createSeller(SellerDto sellerDto){
      Optional<Seller> foundSeller= sellerRepository.findByEmail(sellerDto.getEmail());
      if(foundSeller.isPresent()){
          throw new ResourceExistException("seller with the email address Already Exists");
      }else{
          Seller seller=new Seller();
          seller.setCreatedAt(new Date(System.currentTimeMillis()));
          seller.setUpdatedAt(new Date(System.currentTimeMillis()));
          seller.setEmail(sellerDto.getEmail());
          seller.setType("seller");
          seller.setName(sellerDto.getName());
          seller.setPassword(passwordEncoder.encode(sellerDto.getPassword()));
          seller.setPhone(sellerDto.getPhone());
//          seller.setShopUUID(new Random().nextInt(99999));
          return sellerRepository.save(seller);
      }
    }
    public Seller getSellerById(String id){
        Optional<Seller> seller=sellerRepository.findById(id);
        if(!seller.isPresent()){
            throw new NotFoundResource("Seller not found");
        }else{
            return seller.get();
        }
    }
    public List<Seller> getAllSellers(){
        List<Seller> seller=sellerRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        if(seller.size()==0){
            return new ArrayList<>();
        }else{
            return seller;
        }
    }
    public Seller UpdateSeller(String id,Seller seller){
        Optional<Seller> sellerOptional=sellerRepository.findById(id);
        if(!sellerOptional.isPresent()){
            throw new NotFoundResource("Seller not found");
        }else{
            Seller foundSeller=sellerOptional.get();
            foundSeller.setPhone(seller.getPhone()==null? foundSeller.getPhone():seller.getPhone());
            foundSeller.setName(seller.getName()==null? foundSeller.getName():seller.getName());
            foundSeller.setUpdatedAt(new Date(System.currentTimeMillis()));

            return sellerRepository.save(foundSeller);
        }
    }
    public void deleteSeller(String id){
        Optional<Seller> seller=sellerRepository.findById(id);
        if(!seller.isPresent()){
            throw new NotFoundResource("Seller not found");
        }else{
           sellerRepository.deleteById(id);
        }
    }

}
