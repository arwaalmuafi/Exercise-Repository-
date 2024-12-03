package com.example.exerciseprepository.Controller;
import com.example.exerciseprepository.ApiResponse.ApiResponse;
import com.example.exerciseprepository.Model.User;
import com.example.exerciseprepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        userService.addUSer(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added "));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        userService.updateUSer(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted "));
    }

    @GetMapping("/get/user-id/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }

    @GetMapping("/get/user-username/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        return ResponseEntity.status(200).body(userService.getUserByUsername(username));
    }

    @GetMapping("/get/user-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body( userService.getUserByEmail(email));
    }

    @GetMapping("/get/users-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }

    @GetMapping("/get/users-age-above/{age}")
    public ResponseEntity getUsersByAgeOrAbove(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.getUsersByAgeOrAbove(age));
    }

    @PostMapping("/check-credentials/{username}/{password}")
    public ResponseEntity checkCredentials(@PathVariable String username, @PathVariable String password) {
       userService.checkCredentials(username, password);
        return ResponseEntity.status(200).body("Both the username and the password are correct");
    }
}
