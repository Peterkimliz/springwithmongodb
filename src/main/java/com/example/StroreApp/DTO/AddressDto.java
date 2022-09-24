package com.example.StroreApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "please enter country name")
    private String country;
    @NotBlank(message = "please enter city name")
    private String city;
    @NotBlank(message = "please enter street name")
    private String street;
    @NotBlank(message = "please enter phone")
    private String phone;
}
