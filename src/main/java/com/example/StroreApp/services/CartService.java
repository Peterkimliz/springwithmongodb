package com.example.StroreApp.services;

import com.example.StroreApp.DTO.CartDto;
import com.example.StroreApp.DTO.CartItemData;
import com.example.StroreApp.DTO.CartItemsDto;
import com.example.StroreApp.Repository.CartRepository;
import com.example.StroreApp.models.Cart;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;

    public Cart createCart(CartDto cartDto, String uid) {
        Customer customer = customerService.getCustomerById(uid);
        Product product = productService.getProductById(cartDto.getProductId());
        Cart cart = new Cart();
        cart.setCreatedAt(new Date(System.currentTimeMillis()));
        cart.setUpdatedAt(new Date(System.currentTimeMillis()));
        cart.setQuantity(cart.getQuantity());
        cart.setCustomer(customer);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }

    public CartItemsDto getCartByUserId(String customerId) {
        List<Cart> carts = cartRepository.findByCustomerOrderByCreatedAt(customerId);
        double totalCost = 0.0;
        List<CartItemData> cartItemData = new ArrayList<>();
        for (Cart cartItem : carts) {
            totalCost += cartItem.getQuantity() * cartItem.getProduct().getPrice();
            cartItemData.add(cartItem);
        }
        CartItemsDto cartItemsDto = new CartItemsDto();
        cartItemsDto.setTotal(totalCost);
        cartItemsDto.setCartItems(cartItemData);

        return cartItemsDto;

    }

}
