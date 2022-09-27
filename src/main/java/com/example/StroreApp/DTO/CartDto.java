package com.example.StroreApp.DTO;

import com.example.StroreApp.models.Customer;
import com.example.StroreApp.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
@NotBlank(message = "please enter product id")
    private String productId;
    @NotBlank(message = "please enter quantity")
    private String quantity;

}
