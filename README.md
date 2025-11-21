# Lucas Store – REST API for E-commerce

Lucas Store is a REST API built with Java and Spring Boot, designed to simulate a simple e-commerce platform. It provides resources for managing users, products, categories, and orders, following a clean and well-structured architecture.
This project is ideal for studying backend development, showcasing professional Spring Boot skills, and serving as a foundation for more advanced e-commerce systems.

## Features

- CRUD operations for Users, Products, Categories, and Orders
- Relationship mapping between entities
- Custom exception handling
- Layered architecture using:
    - Controllers
    - Services
    - Repositories
- Data persistence using Spring Data JPA
- Logical separation of business and domain rules

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (or configured database)
- Maven

## Project Architecture

The application follows a clean layered structure:

```
Controller → Service → Repository → Database
```

### Entities (Models)
- User
- Product
- Category
- Order
- OrderItem
- Payment

### Core Endpoints

Users:

```
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
```

Products:

```
GET    /products
GET    /products/{id}
POST   /products
PUT    /products/{id}
DELETE /products/{id}
```

Categories:

```
GET    /categories
GET    /categories/{id}
POST   /categories
PUT    /categories/{id}
DELETE /categories/{id}
```

Orders:

```
GET    /orders
GET    /orders/{id}
POST   /orders
```

## How to Run the Project
### 1. Clone the repository

```
git clone <your-repo-url>
cd Lucas-Store
```

### 2. Configure the database

The project includes default configuration files:

- `application.properties`
- `application-test.properties`

If you want to use H2 (default), no additional setup is required.
To use a different database, update:

```
src/main/resources/application.properties
```

Example for H2:

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create
```

### 3. Run the application

Via your IDE (IntelliJ/Eclipse) or through the terminal:

```
mvn spring-boot:run
```

Or:

```
./mvnw spring-boot:run
```

Once started, the API will be available at:

```
http://localhost:8080
```

## Testing

The project includes basic test configuration under:

```
src/test/java/com/lucasstore/store
```

You can run tests using:

```
mvn test
```

## Initial Data (Optional Seeding)

The project contains a configuration class that populates the database with example:
- Users
- Categories
- Products
- Orders

This makes it easier to explore the API during development.
