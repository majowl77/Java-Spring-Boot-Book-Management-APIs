# Book Management API

## Overview
The Book Inventory API is a RESTful web service developed with Spring Boot to manage a collection of books. It offers endpoints for performing CRUD (Create, Read, Update, Delete) operations on book records.

## More Details
- ***Add, update, delete, and view book details.***
- ***Exposes REST endpoints for interacting with the system programmatically.***
- ***Stores book data in PostgreSQL Database***

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradlew

## API Endpoints
``` 

GET /api/books
POST /api/books
GET /api/books/{id}
PUT /api/books/{id}
PATCH /api/books/{id}
DELETE /api/books/{id}

```