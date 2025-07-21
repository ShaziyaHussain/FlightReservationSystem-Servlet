# ✈️ Flight Reservation System (Java Servlet + JDBC)

A simple Java-based web application for booking flights. This project uses JSP, Servlets, JDBC, and MySQL for backend and HTML for frontend.

---

## 🚀 Features

- Search flights by source, destination, and departure date
- View flight details
- Book a reservation
- Stores passenger data in memory or DB

---

## 🛠️ Technologies Used

- Java 8+
- Servlets
- JDBC
- MySQL
- Apache Tomcat
- Maven (Optional)

---

## 📁 Project Structure

- `core/` - Java model and service classes (Flight, Reservation)
- `dao/` - JDBC access logic
- `utils/` - DB connection utility
- `webapp/` -  web.xml
  

---

## 🧪 Database Setup

1. Create a MySQL database named `adv_java`
2. Run the following SQL:

```sql
CREATE TABLE flights (
    id INT PRIMARY KEY,
    airline VARCHAR(100),
    source VARCHAR(50),
    destination VARCHAR(50),
    departure_date DATE,
    arrival_date DATE,
    arrival_time TIME,
    departure_time TIME,
    no_of_stops INT,
    price DOUBLE
);
