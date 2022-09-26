package com.example.StroreApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "seller")
public class Seller {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    @JsonIgnore
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private String type;

}
