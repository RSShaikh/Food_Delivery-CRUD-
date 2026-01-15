# Food Delivery Console App

A Java-based console application that simulates a food delivery system using JDBC and MySQL. Built with clean architecture, modular DAO layers, and interactive menus — perfect for showcasing backend skills.

##  Features

- User registration and management
- Restaurant CRUD operations
- Menu items linked to restaurants
- Cart and cart items handling
- Order placement and tracking
- Payment processing
- Delivery assignment and status updates

## Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java (JDBC)** | Core application logic |
| **MySQL** | Relational database |
| **Eclipse IDE** | Development environment |
| **Git & GitHub** | Version control and hosting |

##  Project Structure
src/
├── com.project.food_delivery
│   ├── Main.java
├── com.project.food_delivery.models
│   ├── User.java
│   ├── Restaurant.java
│   └── ...
├── com.project.food_delivery.dao
│   ├── UserDao.java
│   ├── RestaurantDao.java
│   └── ...
├── com.project.food_delivery.dao.impl
│   ├── UserDaoImpl.java
│   ├── RestaurantDaoImpl.java
│   └── ...


## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/RSShaikh/Food_Delivery-CRUD-.git
   Import into Eclipse

2. File → Import → Existing Projects into Workspace

3. Set up MySQL database

Use the provided schema in SQL_PROJECT.pdf

Update DB credentials in DAO classes

4. Run Main.java

Use console menu to interact with the system

##License
This project is open-source and free to use for learning and portfolio purposes.

##Author
Rukhsar Shaikh  
Mumbai, India
