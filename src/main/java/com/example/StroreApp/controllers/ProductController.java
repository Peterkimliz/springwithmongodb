package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.ProductDto;
import com.example.StroreApp.models.Product;
import com.example.StroreApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/{id}")
    public ResponseEntity<Product> createProduct(@PathVariable("id") String id , @RequestBody @Validated ProductDto productDto) {
        Product product=productService.createProduct(productDto,id);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, products.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @GetMapping("/all/seller/{id}")
    public ResponseEntity<List<Product>> getAllProductsBySeller(@PathVariable("id") String id) {
        List<Product> products = productService.getAllProductsBySellerId(id);
        return new ResponseEntity<List<Product>>(products, products.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Product productById = productService.getProductById(id);
        return new ResponseEntity<Product>(productById,  HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id,@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(id,product),  HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted successfully", HttpStatus.OK);
    }

}
