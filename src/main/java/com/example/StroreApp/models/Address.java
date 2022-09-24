package com.example.StroreApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String id;
    private Customer userid;
    private String country;
    private String city;
    private String street;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
}
