package com.example.StroreApp.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto {
    @NotBlank(message = "please Enter name")
    private String name;
    @NotBlank(message = "please Enter email")
    private String email;
    @NotBlank(message = "please Enter phone")
    private String phone;
    @NotBlank(message = "please Enter password")
    private String password;
}
