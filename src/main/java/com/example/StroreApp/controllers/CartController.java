package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.CartDto;
import com.example.StroreApp.DTO.CartItemsDto;
import com.example.StroreApp.models.Cart;
import com.example.StroreApp.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/{id}")
    public ResponseEntity<Cart> createCart(@PathVariable("id") String id, @RequestBody @Validated CartDto cartDto) {
        Cart cart = cartService.createCart(cartDto, id);
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemsDto> getUserCart(@PathVariable("id") String id) {
        return new ResponseEntity<CartItemsDto>(cartService.getCartByUserId(id), HttpStatus.OK);
    }
}
