package com.example.shopping_cart;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.ProductRepository;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository  productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(@Nullable String... args) {
        productRepository.save(new Product(1L, "Laptop", 50000));
        productRepository.save(new Product(2L, "Iphone", 80000));
        productRepository.save(new Product(3L, "Headphones", 1000));

    }


}
