// // main/java/com/casinotest/casino_api/UserController.java

// package main.java.com.casinotest.casino_api;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;


// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @PostMapping
//     public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
//         UserDto newUser = userService.createUser(request);
//         return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
//     }

//     @GetMapping("/{userId}")
//     public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
//         UserDto user = userService.getUser(userId);
//         return ResponseEntity.ok(user);
//     }

//     // Other endpoints for updating and deleting users
// }
