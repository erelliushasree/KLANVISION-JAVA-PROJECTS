# KIANVISION-LIBRARY-CATALOG-SYSTEM

## 📚 Library Catalog System

A simple **console-based Library Catalog System developed in Java** as part of the KIANVISION Java Programming Internship.

The application allows users to manage a collection of books through a menu-driven console interface. Users can add, search, view, list, and remove books while preventing duplicate Book IDs and handling invalid inputs.

##  Features

* Add a new book with:

    * Book ID
    * Title
    * Author
    * Category
* Search books by title or author
* Case-insensitive book search
* Display all available books
* View complete book details using Book ID
* Remove a book using Book ID
* Prevent duplicate Book IDs
* Validate user input
* Handle invalid menu choices
* Prevent invalid and negative Book IDs
* Prevent empty title, author, and category
* Menu-driven console interface

##  Technologies Used

* **Java**
* **Core Java**
* **Object-Oriented Programming (OOP)**
* **ArrayList**
* **Scanner**
* **IntelliJ IDEA**

##  Project Structure

```text
KIANVISION-LIBRARY-CATALOG-SYSTEM
│
└── src
    └── library
        ├── Book.java
        ├── Library.java
        └── LibraryApp.java
```

### `Book.java`

Represents a book in the library.

It stores:

* Book ID
* Title
* Author
* Category

The class uses **encapsulation** by keeping its fields private and providing getter methods.

### `Library.java`

Manages the collection of books using an `ArrayList`.

It provides methods for:

* Adding books
* Listing books
* Searching books
* Viewing book details
* Removing books
* Preventing duplicate Book IDs

### `LibraryApp.java`

Contains the `main()` method and provides the console-based menu.

It handles:

* User input
* Menu selection
* Input validation
* Calling the appropriate Library operations

##  OOP Concepts Used

### Encapsulation

Book attributes are declared as private and accessed through getter methods.

### Classes and Objects

The project uses separate classes for representing books and managing the library.

### Abstraction

Library operations such as adding, searching, listing, viewing, and removing books are implemented as methods, keeping the main application logic simple.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <https://github.com/erelliushasree/KLANVISION-LIBRARY-CATALOG-SYSTEM/tree/master/src/library>
```

### 2. Open the project

Open the project in **IntelliJ IDEA** or another Java-compatible IDE.

### 3. Run the application

Run:

```text
LibraryApp.java
```

The console menu will be displayed.

##  Sample Menu

```text
===== Library Catalog System =====
1. Add Book
2. Search Book
3. List Books
4. View Book Details
5. Remove Book
6. Exit

Enter your choice:
```

##  Sample Output

```text
Enter your choice: 1
Enter Book ID: 101
Enter Book Title: Java Programming
Enter Author: James Gosling
Enter Category: Programming

Book added successfully
```

### Duplicate Book ID

```text
Enter Book ID: 101
Enter Book Title: Python Programming
Enter Author: Guido Van Rossum
Enter Category: Programming

Book Id already exists
```

### Search Book

```text
Enter title or author to search: java

Book ID: 101
Title: Java Programming
Author: James Gosling
Category: Programming
```

### Remove Book

```text
Enter Book ID: 101

Book removed successfully
```

##  Internship Task

This project was developed as part of the **KIANVISION Java Programming Internship** to demonstrate practical knowledge of Java programming, Object-Oriented Programming, collections, user input handling, and basic application development.

##  Author

**Erelli Ushasree**

Java Programming Intern
