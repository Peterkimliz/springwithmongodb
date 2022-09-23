package com.example.StroreApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotBlank(message = "please enter your name")
    private String name;
    @NotBlank(message = "please enter your email")
    private String email;
    @NotBlank(message = "please enter your phone")
    private String phone;
    @NotBlank(message = "please enter your password")
    private String password;
}
