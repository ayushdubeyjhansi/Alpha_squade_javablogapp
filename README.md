# Java GUI Blog Application

A robust, desktop-based blogging platform built with **Java Swing** and **MySQL**. This application demonstrates advanced Object-Oriented Programming (OOP) concepts, JDBC connectivity, and resilient system design.

## 🚀 Features

* **User Authentication:** Secure Login and Registration system with role-based access (Admin/Regular User).
* **Dynamic Feed:** Real-time viewing of blog posts.
* **CRUD Operations:** Create, Read, Update, and Delete blog posts.
* **Interactive Features:** Support for **Comments** and **Likes** on posts.
* **Resilient Backend:**
    * **Hybrid Storage:** Primarily uses MySQL.
    * **Fail-safe Memory Mode:** Automatically switches to in-memory storage if the database connection fails, ensuring the app never crashes.
* **Multithreading:** Includes an `AutoRefreshTask` background thread to keep data consistent without freezing the UI.

## 🛠️ Tech Stack

* **Language:** Java (JDK 8+)
* **Frontend:** Java Swing (AWT/Swing components)
* **Database:** MySQL
* **Connectivity:** JDBC (Java Database Connectivity)
* **Architecture:** Modular OOP design

## ⚙️ Prerequisites

Before running the application, ensure you have the following installed:

1.  **Java Development Kit (JDK)** (Version 8 or higher)
2.  **MySQL Server**
3.  **MySQL JDBC Driver** (Connector/J) added to your project's classpath.

## 📥 Installation & Setup

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/ayushdubeyjhansi/JavaBlogApp.git](https://github.com/ayushdubeyjhansi/JavaBlogApp.git)
    cd JavaBlogApp
    ```

2.  **Database Configuration**
    * Create a MySQL database (e.g., `blog_db`).
    * Update the `DatabaseConnection.java` (or equivalent config file) with your MySQL credentials:
        ```java
        private static final String URL = "jdbc:mysql://localhost:3306/blog_db";
        private static final String USER = "root";
        private static final String PASSWORD = "your_password";
        ```
    * *Note: The application will automatically create necessary tables on the first run if they don't exist.*

3.  **Compile the Project**
    Make sure the JDBC driver is in your classpath.
    ```bash
    javac -cp .:mysql-connector-j-8.x.x.jar *.java
    ```

4.  **Run the Application**
    ```bash
    java -cp .:mysql-connector-j-8.x.x.jar Main
    ```
    *(Note: Replace `;` with `:` if you are on Windows).*

## 🧩 Project Structure

The project follows a clean separation of concerns:
* **Models:** Data classes representing `User`, `Post`, etc.
* **DAO (Data Access Objects):** Handles SQL queries and database interactions.
* **UI (Views):** Swing frames and panels for the graphical interface.
* **Utils:** Helper classes for database connections and session management.

## 🛡️ Resilience

One of the key highlights of this project is its fault tolerance. If the MySQL service goes down, the application catches the `SQLException` and seamlessly transitions to a local `ArrayList` based storage, allowing the user to continue working in a "Offline/Memory" mode.

---
*Created by [Ayush Dubey]*
