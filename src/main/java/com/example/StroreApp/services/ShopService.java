package com.example.StroreApp.services;

import com.example.StroreApp.DTO.ShopDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Exceptions.ResourceExistException;
import com.example.StroreApp.Repository.ShopRepository;
import com.example.StroreApp.models.Seller;
import com.example.StroreApp.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ShopService {
    @Autowired
    SellerService sellerService;
    @Autowired
    ShopRepository shopRepository;

    public Shop createShop(ShopDto shopDto, Seller seller) {
        List<Shop> shopList = shopRepository.findBySeller(seller.getId());
        if (shopList.size() >= 1) {
            throw new ResourceExistException("You cannot create multiple shops");
        } else {
            Shop shop = new Shop();
            shop.setCreatedAt(new Date(System.currentTimeMillis()));
            shop.setUpdatedAt(new Date(System.currentTimeMillis()));
            shop.setName(shopDto.getName());
            shop.setLocation(shopDto.getLocation());
            shop.setSeller(seller);
            return shopRepository.save(shop);
        }

    }

    public List<Shop> getAllShops() {
        List<Shop> shop = shopRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        if (shop.size() == 0) {
            return new ArrayList<>();
        } else {
            return shop;
        }
    }

    public Shop getShopById(String shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (!shop.isPresent()) {
            throw new NotFoundResource("shop doesnot exist");
        } else {
            return shop.get();
        }
    }

    public Shop updateShop(String shopId, Shop updateShop) {
        Optional<Shop> shop = shopRepository.findById(shopId);

        if (!shop.isPresent()) {
            throw new NotFoundResource("shop doesnot exist");
        } else {
            Shop foundShop = shop.get();
            foundShop.setUpdatedAt(new Date(System.currentTimeMillis()));
            foundShop.setName(updateShop.getName() == null ? foundShop.getName() : updateShop.getName());
            foundShop.setLocation(updateShop.getLocation() == null ? foundShop.getLocation() : updateShop.getLocation());
            foundShop.setImage(updateShop.getImage() == null ? foundShop.getImage() : updateShop.getImage());

            return shopRepository.save(foundShop);
        }
    }

}
