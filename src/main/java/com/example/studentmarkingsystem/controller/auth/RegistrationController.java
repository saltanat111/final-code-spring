package com.example.studentmarkingsystem.controller.auth;
// Or your preferred package

import com.example.studentmarkingsystem.dto.auth.RegistrationRequest;
import com.example.studentmarkingsystem.entity.Users; // Or your main user entity
import com.example.studentmarkingsystem.service.UserService; // Assuming you have a UserService
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        String role = registrationRequest.getRole();
        try {
            userService.registerNewUser(registrationRequest, role); // Pass the role to the service
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
