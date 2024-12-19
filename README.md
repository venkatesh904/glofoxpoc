# Glofox Task

## Overview
This project implements the backend functionality for managing studio classes and bookings using RESTful APIs. It is developed using **Spring Boot** with a layered architecture for simplicity and maintainability.

## Features
### 1. Class Management
- API to create classes (`/classes`).
- Retrieve all classes.

### 2. Booking Management
- API to book classes (`/bookings`).
- Retrieve all bookings.

## Project Architecture
The application follows a **Layered Architecture**:

1. **Controller Layer**:
   - Handles HTTP requests and responses.
   - Entry point for the API endpoints.

2. **Service Layer**:
   - Contains the business logic.
   - Validates inputs and processes requests.

3. **Data Layer**:
   - Uses in-memory storage (`ConcurrentHashMap`) to manage classes and bookings.
   - Abstracted to allow future integration with a database.

4. **Model Layer**:
   - Represents domain objects like `StudioClass`, `Booking`, and `BookingRequest`.

## Technologies Used
- **Java 11**
- **Spring Boot** (2.x)
- **JUnit 5** for testing
- **Maven** for dependency management

## API Endpoints
### Classes API
1. **Create Class**
   - **URL**: `/classes`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "name": "Pilates",
       "startDate": "2024-01-01",
       "endDate": "2024-01-10",
       "capacity": 20
     }
     ```
   - **Response**:
     ```json
     {
       "message": "Class created successfully",
       "success": true
     }
     ```

2. **Get Classes**
   - **URL**: `/classes`
   - **Method**: GET
   - **Response**: Array of class objects.

### Bookings API
1. **Create Booking**
   - **URL**: `/bookings`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "name": "John Doe",
       "date": "2024-01-01"
     }
     ```
   - **Response**:
     ```json
     {
       "message": "Booking successful",
       "success": true
     }
     ```

2. **Get Bookings**
   - **URL**: `/bookings`
   - **Method**: GET
   - **Response**: Map of dates to booking objects.

## How to Run
1. **Pre-requisites**:
   - Java 11 or higher
   - Maven installed

2. **Steps**:
   - Clone the repository.
     ```
     git clone <repo-url>
     ```
   - Navigate to the project directory.
     ```
     cd <project-folder>
     ```
   - Build the project using Maven.
     ```
     mvn clean install
     ```
   - Run the application.
     ```
     mvn spring-boot:run
     ```

3. **Access APIs**:
   - Open Postman or use cURL to interact with the endpoints at `http://localhost:8080`.

## Testing
- Run unit tests using Maven.
  ```
  mvn test
  ```

## Future Enhancements
- Add database integration (e.g., PostgreSQL or MySQL).
- Implement authentication and authorization for APIs.
- Add input validation using Spring Boot Validator.
- Enhance error handling with detailed response codes.
- Add support for class capacity checks during booking.

## License
This project is licensed under the MIT License.
