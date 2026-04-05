package com.example.shopping_cart.controller;

import com.example.shopping_cart.DTO.LoginRequest;
import com.example.shopping_cart.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest body) {

        if ("aditya".equals(body.username) &&
                "password".equals(body.password)) {

            String token = jwtUtil.generateToken(body.username);
            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
