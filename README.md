# Casino App API

## Project Overview

Welcome to the Casino App API repository! This Java-based API provides essential functionalities for managing user accounts and tracking their activity within a casino app. Whether you're developing a new casino application or integrating casino features into an existing project, this API is designed to make user management and financial tracking seamless.

## Getting Started

To incorporate the Casino App API into your project, follow these simple steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/casino-app-api.git
   ```

2. Set up the API in your Java project.

## API Functions

### 1. Create a User

#### Endpoint:

```
POST /api/user
```

#### Parameters:

- `username` (string): The username of the new user.
- `initial_balance` (double): The initial balance for the user's casino account.

#### Response:

- `200 OK`: User created successfully.
- `400 Bad Request`: Invalid parameters provided.

### 2. Delete a User

#### Endpoint:

```
DELETE /api/user/{userId}
```

#### Parameters:

- `userId` (string): The unique identifier of the user to be deleted.

#### Response:

- `200 OK`: User deleted successfully.
- `404 Not Found`: User not found.

### 3. Show User/s

#### Endpoint:

```
GET /api/user/{userId}
```

#### Parameters:

- `userId` (string): The unique identifier of the user to be retrieved. If not provided, returns a list of all users.

#### Response:

- `200 OK`: User information retrieved successfully.
- `404 Not Found`: User not found.

### 4. Money Won

#### Endpoint:

```
GET /api/user/{userId}/money-won
```

#### Parameters:

- `userId` (string): The unique identifier of the user.

#### Response:

- `200 OK`: Amount of money won by the user retrieved successfully.
- `404 Not Found`: User not found.

### 5. Money Lost

#### Endpoint:

```
GET /api/user/{userId}/money-lost
```

#### Parameters:

- `userId` (string): The unique identifier of the user.

#### Response:

- `200 OK`: Amount of money lost by the user retrieved successfully.
- `404 Not Found`: User not found.

## Contributing

If you find issues or have suggestions for improvements, feel free to open an issue or create a pull request. Your contributions are highly welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

Special thanks to all contributors who have helped in the development of this Casino App API. Your efforts are greatly appreciated!