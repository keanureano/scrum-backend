# Scrum Tracker Backend API

Welcome to the Scrum Tracker Backend API! This Spring Boot application is a simple but powerful RESTful API with JWT authentication. This API serves as a reliable backend foundation for our Scrum management project.

## Pre-made Users

During startup, `UserDataInitializer.java` automatically creates three pre-made users with different roles:

1. User Account:

   - Email: user@example.com
   - Password: userpassword
   - Roles: USER

2. Admin Account:

   - Email: admin@example.com
   - Password: adminpassword
   - Roles: ADMIN, USER

3. Inactive Account:
   - Email: inactive@example.com
   - Password: inactivepassword
   - Roles: INACTIVE

## Endpoints

### Register User

Register a new user with email, name, and password.

```http
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "email": "email@example.com",
  "name": "name",
  "password": "password"
}
```

### Login User

Login with email and password to obtain an authentication token.

```http
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "email": "email@example.com",
  "password": "password"
}
```

### Retrieve Data

To retrieve data from the API, you'll need to use a valid JWT token obtained from the registration or login process.

```http
GET http://localhost:8080/api
Authorization: Bearer {TOKEN}
```

Make sure you have successfully registered or logged in to obtain the `{TOKEN}` and replace it in the request header for authorization. This token will grant you access to the protected endpoints of the API.

## Setup

1. Clone this repository.
2. Open the project in your preferred IDE.
3. Configure your database settings in `application.properties`.
4. Build and run the application.
5. Use the provided HTTP requests to interact with the API.
