package com.analyser.resumeanalyzer.controller;

import com.analyser.resumeanalyzer.entity.User;
import com.analyser.resumeanalyzer.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.analyser.resumeanalyzer.dto.LoginRequestDTO;
import com.analyser.resumeanalyzer.dto.LoginResponseDTO;
import com.analyser.resumeanalyzer.dto.UserDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody UserDTO request) {
	        User createdUser = userService.saveUser(request.getName(), request.getEmail(), request.getPassword());
	        return ResponseEntity.ok(createdUser);
	    }  
     
	    @PutMapping("/{userId}/password")
	    public ResponseEntity<String> updatePassword(
	            @PathVariable Long userId,
	            @RequestBody Map<String, String> requestBody) {

	        String newPassword = requestBody.get("newPassword");

	        if (newPassword == null || newPassword.isBlank()) {
	            return ResponseEntity.badRequest().body("New password must not be empty");
	        }

	        boolean success = userService.updatePassword(userId, newPassword);

	        if (success) {
	            return ResponseEntity.ok("Password updated successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
	        boolean isAuthenticated = userService.authenticateUser(
	                loginRequest.getEmail(), loginRequest.getPassword());

	        if (isAuthenticated) {
	            return ResponseEntity.ok(new LoginResponseDTO("Login successful!", true));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                    .body(new LoginResponseDTO("Invalid email or password.", false));
	        }
	    }
	        
	    /*@GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        UserDTO user = userService.getUserById(id);
	        return ResponseEntity.ok(user);
	    }*/
}
