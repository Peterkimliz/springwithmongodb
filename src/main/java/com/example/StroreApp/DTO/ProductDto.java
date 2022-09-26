package com.example.StroreApp.DTO;

import com.example.StroreApp.models.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotBlank(message = "please enter product name")
    private String name;
    @NotBlank(message = "please enter product description")
    private String description;
   @NotBlank(message = "please enter product images")
    private List<String> imageUrl;
    @NotBlank( message= "please enter product price")
    private String price;
    @NotBlank( message= "please enter product Quantity")
    private String quantity;

}
