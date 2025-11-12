# 🏢 Employee Management System

A Spring Boot application for managing employees, departments, and their relationships.  
This project demonstrates CRUD operations, REST APIs, exception handling, and database integration using **Spring Boot, Spring Data JPA, and MySQL**.

---

## 🚀 Features

- Add, update, delete, and fetch employees
- Manage departments and assign employees
- REST API-based architecture (testable in Postman)
- Global exception handling
- MySQL database integration with JPA/Hibernate
- Secure APIs with Spring Security (basic authentication)
- Clean and scalable project structure

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Data JPA, Hibernate  
- **Database:** MySQL  
- **Security:** Spring Security (Basic Authentication)  
- **Build Tool:** Maven  
- **IDE:** IntelliJ IDEA / VS Code  

---

## ⚙️ API Endpoints

### 👤 Employee APIs
- `POST /api/employees` → Add new employee  
- `GET /api/employees` → Get all employees  
- `GET /api/employees/{id}` → Get employee by ID  
- `PUT /api/employees/{id}` → Update employee  
- `DELETE /api/employees/{id}` → Delete employee  

### 🏬 Department APIs
- `POST /api/departments` → Add new department  
- `GET /api/departments` → Get all departments  
- `GET /api/departments/{id}` → Get department by ID  
- `PUT /api/departments/{id}` → Update department  
- `DELETE /api/departments/{id}` → Delete department  

---

## 🛠️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/shouryagupta67/Employee-Management-System.git
   cd Employee-Management-System
