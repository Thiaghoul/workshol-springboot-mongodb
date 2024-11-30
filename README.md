
---

# Workshop MongoDB API

RESTful API to manage a social media-like application, including users, posts, and comments. The project follows best API design practices, using Spring Boot and MongoDB for efficient data storage and retrieval.

---

## Features

### **User Management**
- List all users
- Retrieve user by ID
- Create, update, and delete users
- Fetch posts created by a user

### **Post Management**
- Retrieve post by ID
- List posts containing specific text in the title
- Perform advanced full-text search across posts by title, body, or comments
- Associate posts with a specific author (user)
- Add comments to posts

### **Comment Management**
- Associate comments with posts and authors
- Allow nested objects for comments within posts

---

## Testing Data

### **Data Initialization**
For testing purposes, the application creates sample data for `User`, `Post`, and `Comment` entities when the application starts. This is achieved through the `Instantiation` class.

- **Users:** Example users are created with names and email addresses.
- **Posts:** Posts are pre-created and linked to existing users.
- **Comments:** Comments are created and associated with posts and authors.

This initialization ensures that a default set of data is available for testing the API endpoints without manually creating entities via POST requests.

---

## Technologies Used

### **Backend**
- Spring Boot (REST APIs)
- Spring Data MongoDB
- Jackson (JSON serialization/deserialization)

### **Database**
- MongoDB (NoSQL database for scalability and performance)

### **Additional Dependencies**
- Lombok (to reduce boilerplate code)

---

## Project Structure

![Screenshot from 2024-11-30 11-08-36](https://github.com/user-attachments/assets/598ea8de-50c5-403b-8e1d-a44471fa5e82)

### **Entities**
- Represents documents in the MongoDB database:
  - `User`: Represents the users of the system.
  - `Post`: Represents posts created by users.
  - `Comment`: Represents comments linked to posts.

### **DTOs (Data Transfer Objects)**
- Simplifies communication between API layers:
  - `UserDTO`: For lightweight user data.
  - `AuthorDTO`: Represents post and comment authors.
  - `CommentDTO`: For comments associated with posts.

### **Repositories**
- Interfaces for MongoDB interaction:
  - `UserRepository`
  - `PostRepository`

### **Services**
- Implements business logic:
  - `UserService`
  - `PostService`

### **Resources**
- REST controllers that define API endpoints:
  - `UserResource`
  - `PostResource`

### **Exception Handling**
- Centralized error handling with clear error messages:
  - Handles `ObjectNotFoundException` and other runtime exceptions.

---

## Endpoints

### **Users**
- `GET /users`: List all users
- `GET /users/{id}`: Retrieve a user by ID
- `POST /users`: Create a new user
- `PUT /users/{id}`: Update user information
- `DELETE /users/{id}`: Delete a user by ID
- `GET /users/{id}/posts`: Retrieve all posts by a user

### **Posts**
- `GET /posts/{id}`: Retrieve a post by ID
- `GET /posts/titlesearch?text={text}`: Search for posts by title
- `GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}`: Advanced search for posts by title, body, and comments within a date range

---

## Request Examples

### **Create a User**
**Endpoint:**
`POST /users`

**Body:**
```json
{
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```

**Response:**
```json
{
    "id": "64f7b5f67e1a2a1dfbf1",
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```

---

## Data Initialization Example

**Preloaded User:**
```json
{
    "id": "164f7b5f67akdlsa1dfbf1
    "name": "Alex Green",
    "email": "alex.green@example.com"
}
```

**Preloaded Post:**
```json
{
    "id": "164asda98kdlsa1dfbf1",
    "title": "My First Post",
    "body": "This is the content of the first post",
    "author": {
        "id": "1",
        "name": "Alex Green"
    },
    "comments": [
        {
            "text": "Great post!",
            "date": "2024-11-30T00:00:00Z",
            "author": {
                "id": "1kdlsa1dfbf164asda98",
                "name": "Jane Smith"
            }
        }
    ]
}
```

---

## How to Run the Project

### Prerequisites
- JDK 17+
- Maven
- MongoDB server running locally or remotely

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Thiaghoul/workshop-mongodb.git
   ```
2. Configure MongoDB connection in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/workshop-mongodb
   ```
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the API at `http://localhost:8080`.

---

## Author
Developed by **Thiago Henriques Nunes**.

---

