package com.example.StroreApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    @JsonIgnore
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Boolean activated=false;
}
