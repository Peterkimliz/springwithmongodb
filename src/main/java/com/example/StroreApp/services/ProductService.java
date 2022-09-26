package com.example.StroreApp.services;

import com.example.StroreApp.DTO.ProductDto;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Repository.ProductRepository;
import com.example.StroreApp.models.Product;
import com.example.StroreApp.models.Seller;
import com.example.StroreApp.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShopService shopService;

    public Product createProduct(ProductDto productDto, String shopid) {
        Shop shop = shopService.getShopById(shopid);
        Product product = new Product();
        product.setCreatedAt(new Date(System.currentTimeMillis()));
        product.setUpdatedAt(new Date(System.currentTimeMillis()));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(Integer.parseInt(productDto.getPrice()));
        product.setShop(shop);
        product.setQuantity(Integer.parseInt(productDto.getQuantity()));
        product.setImageUrl(productDto.getImageUrl());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        if (products.size() == 0) {
            return new ArrayList<>();
        } else {
            return products;
        }
    }
    public List<Product> getAllProductsBySellerId(String id) {
        List<Product> products = productRepository.findBySeller(id,false);
        if (products.size() == 0) {
            return new ArrayList<>();
        } else {
            return products;
        }
    }
    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new NotFoundResource("product doesnot exists");
        } else {
            return product.get();
        }
    }
    public Product updateProduct(String id,Product product) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (!foundProduct.isPresent()) {

            throw new NotFoundResource("product doesnot exists");
        } else {
            Product savedProduct= foundProduct.get();
            savedProduct.setUpdatedAt(new Date(System.currentTimeMillis()));
            savedProduct.setName(product.getName()==null? savedProduct.getName() : product.getName());
//            savedProduct.setPrice(product.getPrice()==null? savedProduct.getPrice() : product.getPrice());
            savedProduct.setDescription(product.getDescription()==null? savedProduct.getDescription() : product.getDescription());
            savedProduct.setImageUrl(product.getImageUrl()==null?savedProduct.getImageUrl():product.getImageUrl());
            return productRepository.save(savedProduct);
        }
    }
    public void deleteProduct(String id) {
        Optional<Product> foundPoduct = productRepository.findById(id);
        if (!foundPoduct.isPresent()) {
            throw new NotFoundResource("product doesnot exists");
        } else {
            Product product=new Product();
            product.setDeleted(true);
            product.setUpdatedAt(new Date(System.currentTimeMillis()));
            productRepository.save(product);

        }
    }

}
