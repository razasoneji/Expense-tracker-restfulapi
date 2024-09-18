# Expense Tracker API

## Overview

This project is a Spring Boot REST API for an Expense Tracker application. It allows users to manage their expenses, categories, and users through a set of RESTful endpoints.

## Features

- **User Management**: Create, read, update, and delete users.
- **Category Management**: Create, read, update, and delete expense categories.
- **Expense Management**: Create, read, update, and delete expenses, and associate them with users and categories.

## Endpoints

### Users

- `POST /api/users` - Create a new user.
- `GET /api/users` - Get a list of all users.
- `GET /api/users/{userId}` - Get a specific user by ID.
- `PUT /api/users/{userId}` - Update a user by ID.
- `DELETE /api/users/{userId}` - Delete a user by ID.

### Categories

- `POST /api/categories` - Create a new category.
- `GET /api/categories` - Get a list of all categories.
- `GET /api/categories/{categoryId}` - Get a specific category by ID.
- `PUT /api/categories/{categoryId}` - Update a category by ID.
- `DELETE /api/categories/{categoryId}` - Delete a category by ID.

### Expenses

- `POST /api/expenses` - Create a new expense.
- `GET /api/expenses` - Get a list of all expenses.
- `GET /api/expenses/{expenseId}` - Get a specific expense by ID.
- `GET /api/expenses/category/{categoryId}` - Get expenses by category ID.
- `GET /api/expenses/user/{userId}` - Get expenses by user ID.
- `PUT /api/expenses/{expenseId}` - Update an expense by ID.
- `DELETE /api/expenses/{expenseId}` - Delete an expense by ID.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven

### Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>

2. Navigate to the project directory:
   ```bash
   cd expense-tracker
   
3.Build and run the application:
  ```bash
  mvn spring-boot:run

The application will start on http://localhost:8080.
   
