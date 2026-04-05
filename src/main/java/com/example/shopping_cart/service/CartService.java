package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Long id) {
        cart.removeIf(p -> p.getId().equals(id));
    }

    public void clearCart() {
        cart.clear();
    }

}
