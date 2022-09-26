package com.example.StroreApp.controllers;

import com.example.StroreApp.models.Customer;
import com.example.StroreApp.models.Seller;
import com.example.StroreApp.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seller/")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @GetMapping
    public ResponseEntity<List<Seller>> getSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return new ResponseEntity<List<Seller>>(sellers, sellers.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") String id) {
        return new ResponseEntity<Seller>(sellerService.getSellerById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSellerById(@PathVariable("id") String id, @RequestBody Seller seller) {
        return new ResponseEntity<Seller>(sellerService.UpdateSeller(id, seller), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSellerById(@PathVariable("id") String id) {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>("seller deleted successfully", HttpStatus.OK);
    }
}
