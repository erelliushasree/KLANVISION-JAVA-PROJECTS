# KLANVISION BANK - Banking System

## Project Overview

KLANVISION BANK is a console-based banking application developed using **Java**. The application provides basic banking operations such as account creation, balance management, money transfers, account searching, and transaction history.

The project was developed as part of the **Klanvision Java Programming Internship**.

## Features

* Create a new bank account
* View account details and current balance
* Search accounts by customer name
* Display all bank accounts
* Deposit money
* Withdraw money with balance validation
* Transfer money between accounts
* View transaction history
* Prevent duplicate account numbers
* Validate phone numbers
* Validate account balances and transaction amounts
* Handle invalid numeric input
* Save account information to a file
* Load saved accounts when the application starts
* Save transaction history to a file
* Load transaction history when the application starts

## Technologies Used

* **Java**
* **Object-Oriented Programming (OOP)**
* **ArrayList**
* **File Handling**
* **Exception Handling**
* **IntelliJ IDEA**

## Project Structure

```text
KLANVISION-BANKING-SYSTEM
│
├── src
│   └── banking
│       ├── Account.java
│       ├── Bank.java
│       ├── BankingApp.java
│       ├── FileManager.java
│       └── Transaction.java
│
├── accounts.txt
├── transactions.txt
└── README.md
```

## Application Menu

```text
===== KLANVISION BANK =====
1. Create Account
2. View Account
3. Search Account
4. Deposit Money
5. Withdraw Money
6. Transfer Money
7. Transaction History
8. Display All Accounts
9. Exit
```

## How the Application Works

### 1. Create Account

The user enters:

* Account number
* Customer name
* Phone number
* Initial balance

The application validates the information and prevents duplicate account numbers.

### 2. View Account

The user can enter an account number to view:

* Account number
* Customer name
* Phone number
* Current balance

### 3. Search Account

Users can search for accounts using the customer's name.

### 4. Deposit Money

Users can deposit money into an existing account.

The application checks that the deposit amount is greater than zero and updates the account balance.

### 5. Withdraw Money

Users can withdraw money from an account.

The application checks:

* Withdrawal amount is greater than zero
* Sufficient balance is available

### 6. Transfer Money

Users can transfer money from one account to another.

The application verifies both accounts and checks the sender's available balance before completing the transfer.

### 7. Transaction History

The application records transactions such as:

```text
ACCOUNT CREATED
DEPOSIT
WITHDRAWAL
```

Transaction history can be viewed for an individual account.

### 8. Display All Accounts

The application displays all accounts currently stored in the banking system.

### 9. File Persistence

Account information is stored in:

```text
accounts.txt
```

Transaction history is stored in:

```text
transactions.txt
```

The application loads the saved information when it starts and saves the latest information when the user exits.

## Validation and Error Handling

The application handles common invalid inputs, including:

* Duplicate account numbers
* Invalid phone numbers
* Negative initial balance
* Zero or negative deposit amounts
* Invalid withdrawal amounts
* Insufficient account balance
* Invalid transfer amounts
* Invalid menu choices
* Non-numeric input where numbers are expected

## Sample Transaction Flow

```text
Create Account
      ↓
Initial Balance
      ↓
Deposit / Withdraw
      ↓
Transfer Money
      ↓
Transaction History
      ↓
Save Data
      ↓
Load Data on Next Run
```

## Learning Outcomes

Through this project, I practiced and strengthened my understanding of:

* Java classes and objects
* Constructors
* Encapsulation
* Methods
* ArrayList
* Loops
* Switch statements
* Conditional statements
* Exception handling
* File handling
* Object-oriented programming
* Basic banking system design

## Future Improvements

The application can be further enhanced by adding:

* User login and authentication
* PIN/password protection
* Admin and customer roles
* GUI using Java Swing or JavaFX
* Database connectivity using MySQL and JDBC
* Better transaction reporting
* Account deletion and modification
* Account statement generation

## Author

**Erelli Usha**

Developed as part of the **Klanvision Java Programming Internship**.
