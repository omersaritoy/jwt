This project is a simple and secure **JWT-based authentication system** built with **Spring Boot**. It allows users to register, log in, and access protected endpoints using JWT Access Tokens.

## 🚀 Features

- User registration (sign-up)
- User login with JWT generation
- Secure REST endpoints using Spring Security
- JWT Access Token verification
- Simple role-based access control (optional)

## 🧰 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Security
- JWT (io.jsonwebtoken - jjwt)
- Maven
- H2 or PostgreSQL

## 📦 API Endpoints

| Method | Endpoint              | Description                  |
|--------|------------------------|------------------------------|
| POST   | `/api/auth/register`   | Register a new user          |
| POST   | `/api/auth/login`      | Authenticate and get token   |
| GET    | `/api/auth`            | Access user profile (JWT required) |
