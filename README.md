 📚 Online Book Store Management System

A Java Console-Based Application developed using **Core Java, OOP Concepts, JDBC, and MySQL 
that enables users to browse and purchase books while allowing administrators to manage inventory and view sales history.

🚀 Project Overview

The Online Book Store Management System is a role-based application that provides separate functionalities for **Users** and **Administrators**.

User Features

* User Registration
* User Login
* View Available Books
* Purchase Multiple Books
* Generate Bill
* Order History Storage

Admin Features

* Admin Login
* Add New Books
* View Books
* Update Book Quantity
* Delete Books
* View Sales History

All data is stored permanently in a MySQL database and accessed using JDBC.

 🛠 Technologies Used

| Technology    | Purpose                 |
| ------------- | ----------------------- |
| Java          | Application Development |
| JDBC          | Database Connectivity   |
| MySQL         | Database Storage        |
| OOP Concepts  | Application Design      |
| IntelliJ IDEA | Development Environment |

📂 Project Structure

OnlineBookStore
│
├── Models
│   ├── Person.java
│   ├── User.java
│   ├── Admin.java
│   ├── Book.java
│   └── Order.java
│
├── Functions
│   ├── UserDAO.java
│   ├── AdminDAO.java
│   ├── BookDAO.java
│   ├── OrderDAO.java
│   └── BookOperations.java
│
├── util
│   └── DBConnection.java
│
└── BookNest.java

 🗄 Database Design

 Users Table

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
email VARCHAR(100),
password VARCHAR(50),
role VARCHAR(20)
);

 Admins Table

CREATE TABLE admins(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
email VARCHAR(100),
password VARCHAR(50)
);

 Books Table

CREATE TABLE books(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(100),
price DOUBLE,
quantity INT
);

Orders Table

CREATE TABLE orders(
id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(50),
book_name VARCHAR(100),
quantity INT,
total DOUBLE
);


💡 OOP Concepts Implemented

Encapsulation

* Private data members
* Public getters and setters
* Used in User, Admin, Book, and Order classes

 Abstraction

* Implemented using `Person` abstract class
* Defines common attributes for User and Admin

 Inheritance

Person
  │
  ├── User
  │
  └── Admin


 Interface

public interface BookOperations

Methods:

* addBook()
* viewBooks()
* updateQuantity()
* deleteBook()
  
 🔗 JDBC CRUD Operations

 Create

Used for:

* Register User
* Add Book
* Place Order

INSERT
 Read
Used for:

* Login
* View Books
* Sales History

SELECT

Update

Used for:

* Update Quantity
* Reduce Stock After Purchase

UPDATE


Delete

Used for:

* Delete Book

DELETE


 🔄 Application Workflow

 Main Menu


1. Register
2. User Login
3. Admin Login
4. Exit


 User Flow

Login
  ↓
View Books
  ↓
Select Books
  ↓
Enter Quantity
  ↓
Generate Bill
  ↓
Logout

Admin Flow

Login
  ↓
Add Book
  ↓
View Books
  ↓
Update Quantity
  ↓
Delete Book
  ↓
View Sales History
  ↓
Logout


 📊 Sample Bill Generation

========== BILL ==========
Book Name : Twisted Love
Quantity  : 2
Price     : ₹300
Total     : ₹600
==========================


🎯 Key Features

✅ Role-Based Access (Admin/User)

✅ JDBC Database Connectivity

✅ MySQL Data Persistence

✅ Inventory Management

✅ Sales Tracking

✅ Bill Generation

✅ Multiple Book Purchases

✅ Object-Oriented Design

 📚 Learning Outcomes

Through this project, the following concepts were implemented and understood:

* Java OOP Concepts
* JDBC Connectivity
* MySQL Database Operations
* CRUD Operations
* Interfaces and Abstract Classes
* Exception Handling
* Collection Framework Usage
* Console-Based Application Development


 ▶️ How to Run

1. Clone the repository

git clone <repository-url>

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database and tables.

4. Update database credentials in `DBConnection.java`.

5. Add MySQL JDBC Driver.

6. Run:

BookNest.java

# 👩‍💻 Authors

Ayesha Pinjari
Devasena10
vijaya72252

B.Tech CSE | Java Developers

Madanapalle Institute of Technology and Sciences (MITS)

---

# 📄 Conclusion

The Online Book Store Management System is a Java OOP and JDBC-based console application that demonstrates complete database connectivity and CRUD operations. It provides a simple and efficient platform for managing books, handling purchases, generating bills, and maintaining sales records while showcasing core Object-Oriented Programming principles.
