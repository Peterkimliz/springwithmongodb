package com.example.StroreApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shop")
public class Shop {
    @Id
    private String id;
    private String name;
    private String location;
    private String image;
    private Seller seller;
    private Date createdAt;
    private Date updatedAt;
    private boolean activated = false;

}
