package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.CheckoutRequest;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.ProductRepository;
import com.example.shopping_cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    private final ProductRepository productRepository;

    private final CartService cartService;

    public CartController(CartService cartService, ProductRepository productRepository) {
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // TODO - addToCart, getCart, remove, checkout

    @PostMapping("/cart/{id}")
    public List<Product> addToCart(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        cartService.addToCart(product);
        return cartService.getCart();
    }

    @GetMapping("/cart")
    public List<Product> getCart() {
        return cartService.getCart();
    }

    @DeleteMapping("cart/{id}")
    public List<Product> remove(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return cartService.getCart();
    }

    @PostMapping("/checkout")
    public String checkout(@RequestBody CheckoutRequest checkoutRequest) {
        cartService.clearCart();
        return  "Order placed for " + checkoutRequest.getAddress() + " at " + checkoutRequest.getCity() ;
    }





}
