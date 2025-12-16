HOTEL RESERVATION SYSTEM (Java + JDBC)

A console-based Hotel Reservation System developed using Java and JDBC, integrated with a MySQL database.
This project focuses on understanding backend fundamentals, database connectivity, and executing SQL operations through Java.

📌 Project Overview

The Hotel Reservation System allows users to manage hotel bookings through a simple menu-driven interface.
It supports creating, viewing, updating, and deleting reservation records stored in a MySQL database.

The project was built as part of my internship learning journey, with emphasis on core Java, JDBC, and SQL logic.

⚙️ Features

Reserve a hotel room

View all reservations

Retrieve room number using reservation details

Update existing reservation information

Delete reservations

Menu-driven console interface

Real-time interaction with MySQL database

🛠️ Technologies Used

->Java

->JDBC (Java Database Connectivity)

->MySQL

->SQL

->Console-based UI

🗄️ Database Setup

Run the following SQL commands in MySQL Workbench to set up the database:

CREATE DATABASE hotel_db;
USE hotel_db;

CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,        
    
    guest_name VARCHAR(50),
    
    room_number INT,
    
    contact_number VARCHAR(15),
    
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

▶️ How to Run the Project

Install MySQL Server and MySQL Workbench

Create the database and table using the SQL commands above

Download and add MySQL Connector/J to your Java project

Update database credentials in the Java file if required:

->>jdbc:mysql://localhost:3306/hotel_db


Compile and run HotelReservationSystem.java

Use the menu to perform reservation operations

🧠 Learning Outcomes

Through this project, I gained hands-on experience in:

JDBC architecture and database connectivity

Executing SQL queries using Java

Handling Statement and ResultSet objects

Implementing CRUD operations

Designing a structured, menu-driven console application

📚 Learning Resources

This project was developed by learning and practicing concepts from the following resources:

Java JDBC tutorial videos

SQL database practice

Hands-on experimentation with Java and MySQL

⚠️ Note

Update database username and password before running the application

This project is intended for learning and practice purposes

📈 Future Enhancements

Use PreparedStatement for better security

Add room availability tracking

Improve input validation

Extend to a GUI or web-based interface

👤 Author

Amizhthan A
Early-Stage Software Engineer | Java Developer | Tech Explorer
www.linkedin.com/in/amizhthan-a-0083a1319
