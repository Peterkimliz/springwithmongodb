package com.example.StroreApp.DTO;

import com.example.StroreApp.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CartItemData{
    private String id;
    private Product product;
    private int quantity;
}
