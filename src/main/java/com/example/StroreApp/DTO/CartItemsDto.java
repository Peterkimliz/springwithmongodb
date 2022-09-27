package com.example.StroreApp.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartItemsDto {
    private double total;
    private List<CartItemData>cartItems;
}


