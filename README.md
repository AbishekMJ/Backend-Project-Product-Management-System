Here's an example of a **README file** for your **Product Management System Backend Project** using **Spring Boot** and **Postman**.

---

# Product Management System - Backend Project

## Description

This project is a backend implementation of a Product Management System using **Spring Boot**. It allows users to manage products with functionalities to create, read, update, and delete (CRUD) product details through a REST API. The backend uses **Spring Boot** to handle the business logic and **Postman** for testing API requests.

## Features

- **CRUD Operations** for managing products.
- Product information includes:
  - ID
  - Name
  - Category
  - Description
  - Price
  - Quantity
- API endpoints to interact with the products.
- Data is stored in a **relational database** (e.g., MySQL or H2).

## Technologies Used

- **Spring Boot** (Version: x.x.x)
- **Spring Data JPA** (for database operations)
- **MySQL** (or H2 as an in-memory database)
- **Postman** (for API testing)
- **Lombok** (for reducing boilerplate code)

## Prerequisites

Before running this project, ensure you have the following installed:

- **JDK 11 or higher**
- **Maven**
- **MySQL** or **H2 Database** (based on the configuration in `application.properties`)
- **Postman** (for testing API endpoints)

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AbishekMJ/Backend-Project-Product-Management-System.git
   ```

2. **Configure Database**:
   Update the `application.properties` file with your MySQL database credentials.
   Example configuration for MySQL:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/productdb
   spring.datasource.username=root
   spring.datasource.password=rootpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

   Or if you are using **H2** in-memory database:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the Application**:
   You can run the application using your IDE (like IntelliJ IDEA or Eclipse) or through the command line.

   ```bash
   mvn spring-boot:run
   ```

   The backend will be hosted at: `http://localhost:8080`

## API Endpoints

### 1. Create Product (POST)
- **URL**: `/createProduct`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "category": "Electronics",
      "name": "Smartphone",
      "quantity": 50,
      "description": "Latest model smartphone",
      "price": 499.99
    }
    ```

- **Response**:
    ```json
    {
      "message": "Product saved successfully with ID: 1"
    }
    ```

### 2. Get Product by ID (GET)
- **URL**: `/getProduct/{id}`
- **Method**: `GET`
- **Example URL**: `http://localhost:8080/api/products/1`

- **Response**:
    ```json
    {
      "id": 1,
      "category": "Electronics",
      "name": "Smartphone",
      "quantity": 50,
      "description": "Latest model smartphone",
      "price": 499.99
    }
    ```

### 3. Get All Products (GET)
- **URL**: `/getAllProducts`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "id": 1,
        "category": "Electronics",
        "name": "Smartphone",
        "quantity": 50,
        "description": "Latest model smartphone",
        "price": 499.99
      },
      {
        "id": 2,
        "category": "Furniture",
        "name": "Wooden Chair",
        "quantity": 150,
        "description": "Comfortable and sturdy wooden chair for home and office use",
        "price": 79.99
      }
    ]
    ```

### 4. Update Product (PUT)
- **URL**: `/updateProduct`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
      "id": 1,
      "category": "Electronics",
      "name": "Smartphone Pro",
      "quantity": 40,
      "description": "Updated model smartphone with improved features",
      "price": 599.99
    }
    ```

- **Response**:
    ```json
    {
      "message": "Product updated successfully"
    }
    ```

### 5. Delete Product (DELETE)
- **URL**: `/deleteProduct/{id}`
- **Method**: `DELETE`
- **Example URL**: `http://localhost:8080/api/products/1`
- **Response**:
    ```json
    {
      "message": "Product successfully deleted."
    }
    ```

## Testing with Postman

1. **Create Product**: 
   - Open **Postman**.
   - Set the method to **POST**.
   - Use the **/createProduct** URL.
   - In the **Body** section, select **raw** and **JSON** as the format.
   - Paste the example JSON and click **Send**.

2. **Get Product by ID**:
   - Set the method to **GET**.
   - Use the **/getProduct/{id}** URL, replacing `{id}` with the product ID.
   - Click **Send**.

3. **Get All Products**:
   - Set the method to **GET**.
   - Use the **/getAllProducts** URL.
   - Click **Send**.

4. **Update Product**:
   - Set the method to **PUT**.
   - Use the **/updateProduct** URL.
   - In the **Body** section, select **raw** and **JSON** as the format.
   - Paste the example JSON for the updated product and click **Send**.

5. **Delete Product**:
   - Set the method to **DELETE**.
   - Use the **/deleteProduct/{id}** URL, replacing `{id}` with the product ID.
   - Click **Send**.

## Conclusion

This **Spring Boot** backend provides a simple API for managing product information. The system supports all essential CRUD operations and can be tested and interacted with using **Postman**.

Feel free to modify the project to suit your needs, add more functionality, or integrate it with a frontend system to create a full-stack product management solution.

---

This README provides the basic setup instructions, API usage, and Postman testing details for your project. You can further customize it based on your specific requirements.
