package com.example.StroreApp.DTO;

import com.example.StroreApp.models.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    @NotBlank(message = "please enter name")
    private String name;
    @NotBlank(message = "please enter location")
    private String location;
}
