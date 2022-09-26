package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.ShopDto;
import com.example.StroreApp.models.Seller;
import com.example.StroreApp.models.Shop;
import com.example.StroreApp.services.SellerService;
import com.example.StroreApp.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
public class ShopController {
    @Autowired
    SellerService sellerService;
    @Autowired
    ShopService shopService;

    @PostMapping("/create/{id}")
    public ResponseEntity<Shop> createShop(@PathVariable("id") String id,@RequestBody @Validated ShopDto shopDto) {
       Seller seller= sellerService.getSellerById(id);
        return new ResponseEntity<Shop>(shopService.createShop(shopDto,seller), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getSellers() {
        List<Shop> shops = shopService.getAllShops();
        return new ResponseEntity<List<Shop>>(shops, shops.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("id") String id) {
        return new ResponseEntity<Shop>(shopService.getShopById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopById(@PathVariable("id") String id, @RequestBody Shop shop) {
        return new ResponseEntity<Shop>(shopService.updateShop(id, shop), HttpStatus.OK);
    }


}
