# 🛒 MiniCart Backend (Spring Boot + JWT)

A lightweight **Spring Boot backend application** that powers a full-stack shopping cart system with **JWT-based authentication**, **REST APIs**, and **H2 in-memory database**.

---

## 🚀 Features

* 🔐 JWT-based authentication (stateless)
* 🛍️ Product listing API
* 🛒 Add/remove items from cart
* 📦 View cart items
* 🧾 Checkout flow with address input
* ⚡ In-memory database (H2) for quick setup
* 🔒 Protected APIs using Spring Security + JWT filter

---

## 🧱 Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Security**
* **Spring Data JPA**
* **H2 Database**
* **JWT (jjwt 0.11.5)**

---

## 📁 Project Structure

```id="qv0qj7"
src/main/java/com/example/shopping_cart/
├── controller/
│   ├── AuthController.java
│   └── CartController.java
├── service/
│   └── CartService.java
├── repository/
│   └── ProductRepository.java
├── model/
│   └── Product.java
├── security/
│   ├── JwtUtil.java
│   └── JwtFilter.java
├── config/
│   └── SecurityConfig.java
└── DataLoader.java
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```id="vblqgj"
git clone <your-repo-url>
cd minicart-backend
```

---

### 2️⃣ Install dependencies

Make sure you have:

* Java 17+
* Maven

Then run:

```id="eqqap6"
mvn clean install
```

---

### 3️⃣ Run the application

```id="g8g9zb"
mvn spring-boot:run
```

👉 Server runs on:

```id="kzcltc"
http://localhost:8080
```

---

## 🗄️ H2 Database

Access H2 console:

```id="dx2vsc"
http://localhost:8080/h2-console
```

### Default Config:

* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: *(empty)*

---

## 🔐 Authentication Flow

1. User sends login request:

```id="dfjkjf"
POST /auth/login
```

2. Backend validates credentials

3. JWT token is generated

4. Token returned to client

5. Client sends token in headers:

```id="l5rmcq"
Authorization: Bearer <token>
```

6. JWT filter validates token for protected APIs

---

## 📡 API Endpoints

### 🔓 Public

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/auth/login` | Authenticate user |

---

### 🔒 Protected (Require JWT)

| Method | Endpoint         | Description      |
| ------ | ---------------- | ---------------- |
| GET    | `/api/products`  | Get all products |
| POST   | `/api/cart/{id}` | Add item to cart |
| GET    | `/api/cart`      | View cart        |
| DELETE | `/api/cart/{id}` | Remove item      |
| POST   | `/api/checkout`  | Checkout         |

---

## 🔐 Security Configuration

* `/auth/**` → Public
* `/h2-console/**` → Public
* All other endpoints → Protected

JWT validation handled via:

* Custom filter (`JwtFilter`)
* Spring Security context

---

## 🧠 Key Concepts Demonstrated

### 🔹 JWT Authentication

* Stateless authentication
* Token-based authorization
* Secure API access

---

### 🔹 Spring Security

* Filter chain configuration
* Endpoint protection
* Authentication context

---

### 🔹 REST API Design

* Clean endpoint structure
* Proper HTTP methods
* JSON-based communication

---

### 🔹 Database (H2)

* In-memory DB for fast prototyping
* Preloaded product data using `CommandLineRunner`

---

## ⚡ Future Improvements

* Use MySQL/PostgreSQL instead of H2
* Implement user-specific cart
* Add password hashing (BCrypt)
* Store JWT in HttpOnly cookies
* Add role-based authorization
* Add global exception handling

---

## 🧪 Testing

Use Postman:

1. Login → get JWT
2. Use token for protected APIs
3. Test CRUD operations
4. Verify unauthorized access without token

---

## 🎯 Interview Talking Points

This project demonstrates:

* End-to-end authentication using JWT
* Spring Security integration
* RESTful API design
* Backend + frontend integration
* Clean architecture with separation of concerns

---

## 👨‍💻 Author

Aditya Mohapatra

---

## 📌 Notes

This project is built for **full-stack interview preparation**, focusing on:

* Simplicity
* Clarity
* Real-world API flow

---
