# Vacation Booking Application Demo

A full-stack vacation booking application built with Intellij that lets customers browse vacations and excursions, build a cart, and check out.

## Prerequisites

- JDK 17
- MySQL Community Server 8.0.x and MySQL Workbench
- Node.js, npm, and Angular CLI (for the front end)
- IntelliJ IDEA (or any Java IDE)

## Tech Stack

| Layer      | Technology                                               |
|------------|----------------------------------------------------------|
| Back end   | Java 17, Spring Boot, Spring Data JPA / Spring Data REST |
| Database   | MySQL 8.0                                                |
| Front end  | Angular (provided, unmodified)                           |
| Build tool | Maven                                                    |
| IDE        | IntelliJ IDEA                                            |

## Data Model

The database schema is `full-stack-ecommerce` and contains these tables:

- `countries`
- `divisions`
- `customers`
- `vacations`
- `excursions`
- `carts`
- `cart_items`
- `excursion_cartitem` (join table between excursions and cart items)

Entity relationships are documented in the ERD and UML diagrams provided with the course materials.

## Installation

### 1. Create the database

1. Start a local MySQL server.
2. In MySQL Workbench, open `create_and_populate_db.sql` in your local server and run the script.


### 2. Configure the back end

Update `src/main/resources/application.properties` with your local credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/full-stack-ecommerce
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=none
```

> **Note:** Don't commit your real database password to GitHub. Commit a placeholder value instead.

### 3. Run the back end

Run the main `@SpringBootApplication` class from IntelliJ, or from a terminal:

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`. To verify, open an endpoint such as `http://localhost:8080/countries` in a browser and confirm JSON is returned.

### 4. Run the front end

Open "Angular Front End" in a new window in Intellij and run the following commands in a new terminal.

```bash
npm install
ng serve
```

Alternatively you can path directly to "Angular Front End" from your device's terminal and run the commands.

Open `http://localhost:4200` in your browser. The Angular app calls the back end on port 8080.

## Usage

**Browse vacations:** The home page lists the available vacation packages with their prices and descriptions.

**Choose excursions:** Select a vacation to see its excursions, and pick the ones you want to add to your trip.

**Book a vacation:** Add your selections to the cart and review the cart contents and total price.

**Enter customer details:** Fill in your name, address, postal code, phone number, and country and state/province. The back end validates these fields and rejects incomplete or invalid entries.

**Check out:** Submit the order to complete your purchase. The cart is marked as ordered, saved to the database, and a unique order tracking number is shown as confirmation.

The REST API can also be called directly:

```
GET http://localhost:8080/countries
GET http://localhost:8080/vacations
```


