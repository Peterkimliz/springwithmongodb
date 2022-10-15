package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.Payment;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/payment")
public class StripePaymentController {
    @Value("${stipe.apikey}")
    String stripekey;

    @PostMapping("/{id}")
    public Payment createCustomer(@PathVariable("id") String id, @RequestBody @Validated  Payment payment) throws StripeException {
        Stripe.apiKey =stripekey;
        Map<String, Object> params = new HashMap<>();
        params.put("name",payment.getName());
        params.put("email",payment.getEmail());
        params.put("phone",payment.getPhone());
        Customer customer = Customer.create(params);
        payment.setId(customer.getId());
        return payment;
    }
}
