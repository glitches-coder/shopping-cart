package com.example.shopping_cart.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CheckoutRequest {
    private String address;
    private String city;
}
