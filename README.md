# 🏨 Hotel Reservation System (Java)

This is my second hands-on Java project, developed during my internship at **CodeAlpha**.

It is a simple and beginner-friendly **console-based application** that allows users to manage hotel room reservations using a **MySQL database connected through JDBC**.

This project represents the next step in my Java development journey, where I learned how to connect Java applications with databases and perform real-time operations using SQL.

---

## 🚀 Features

- Reserve a hotel room  
- Store reservation details in a MySQL database  
- View all reservations  
- Get room number using reservation ID and guest name  
- Update reservation details  
- Delete reservations  
- Clean and structured Java code  
- Menu-driven console interface  

---

## 🧠 What I Learned

While building this project independently, I practiced:

- Connecting Java applications to MySQL using **JDBC**
- Writing and executing **SQL queries** from Java
- Performing **CRUD operations** (Create, Read, Update, Delete)
- Working with `Statement` and `ResultSet`
- Structuring logic using Java methods
- Handling user input using `Scanner`
- Understanding basic backend application flow

---

## 🛠️ Technologies Used

- Java  
- JDBC (Java Database Connectivity)  
- MySQL  
- SQL  
- Console-based UI  

---

## 🗄️ Database Setup

```sql
CREATE DATABASE hotel_db;
USE hotel_db;

CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(50),
    room_number INT,
    contact_number VARCHAR(15),
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
---

## ▶️ How to Run

Install MySQL Server and MySQL Workbench

Create the database and table using the SQL above

Add MySQL Connector/J to your Java project

Update database credentials in the Java file if required

Run HotelReservationSystem.java

Use the menu options to manage reservations

📌 Note

This project is built for learning and practice purposes, focusing on understanding Java–database connectivity and backend fundamentals.


## 👤 Author

## Amizhthan A
Early-Stage Software Engineer | Java Developer | Tech Explorer
