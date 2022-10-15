package com.example.StroreApp.services;

import com.example.StroreApp.DTO.CartDto;
import com.example.StroreApp.DTO.CartItemData;
import com.example.StroreApp.DTO.CartItemsDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Repository.CartRepository;
import com.example.StroreApp.models.Cart;
import com.example.StroreApp.models.Customer;
import com.example.StroreApp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Product product = productService.getProductById(cartDto.getProductid());
        Cart cart = new Cart();
        cart.setCreatedAt(new Date(System.currentTimeMillis()));
        cart.setUpdatedAt(new Date(System.currentTimeMillis()));
        cart.setQuantity(Integer.parseInt(cartDto.getQuantity()));
        cart.setCustomer(customer);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }

    public CartItemsDto getCartByUserId(String customerId) {
        List<Cart> carts = cartRepository.findByCustomerOrderByCreatedAt(customerId);
        double totalCost = 0.0;
        List<CartItemData> cartItemData = new ArrayList<>();
        for (Cart cartItem : carts) {
            CartItemData cartItemData1=new CartItemData(cartItem);
            totalCost += cartItem.getQuantity() * cartItem.getProduct().getPrice();
            cartItemData.add(cartItemData1);
        }
        CartItemsDto cartItemsDto = new CartItemsDto();
        cartItemsDto.setTotal(totalCost);
        cartItemsDto.setCartItems(cartItemData);

        return cartItemsDto;

    }
    public void deleteCart(String id){
       Optional<Cart> cart=cartRepository.findById(id);
       if (!cart.isPresent()){
           throw new NotFoundResource("cart item not found");
       }else{
           cartRepository.deleteById(id);
       }
    }
    public void deleteEntireCart(String id){
       List<Cart> cart=cartRepository.findByCustomerOrderByCreatedAt(id);
       if(cart.size()==0){
           throw new NotFoundResource("Your cart has no items");
       }else{
           for (Cart cartItem:cart){
               cartRepository.deleteById(cartItem.getId());
           }
       }
    }

}
