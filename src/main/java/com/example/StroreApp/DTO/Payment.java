package com.example.StroreApp.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Payment {
    private String id;
    @NotBlank(message = "please enter your email address")
    private String email;
    @NotBlank(message = "please enter your name")
    private String name;
    @NotBlank(message = "please enter your phone number")
    private String phone;

}
